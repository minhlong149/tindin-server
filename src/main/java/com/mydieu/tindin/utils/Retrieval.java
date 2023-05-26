package com.mydieu.tindin.utils;

import com.mydieu.tindin.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Retrieval {
    public static List<JobPost> sortJobPosts(List<JobPost> jobs, Applicant applicant) {
        // Create a document for each job and the applicant
        List<String> applicantDocument = createDocument(applicant);
        List<List<String>> jobDocuments = new ArrayList<>();
        for (JobPost job : jobs) {
            jobDocuments.add(createDocument(job));
        }

        // Create a vocabulary of all the unique words from the documents
        List<String> vocabulary = createVocabulary(applicantDocument, jobDocuments);

        // For each word in the document, find its TF-IDF score,
        // and assign the score to the corresponding position in the vector.
        Double[] applicantVector = createVector(applicantDocument, vocabulary);
        Double[] jobScores = new Double[jobs.size()];
        for (int i = 0; i < jobs.size(); i++) {
            Double[] jobVector = createVector(jobDocuments.get(i), vocabulary);

            // Calculate the cosine similarity between the document vector and the query vector
            jobScores[i] = cosineSimilarity(applicantVector, jobVector);
        }

        // Sort the documents by their cosine similarity score
        jobs.sort(Comparator.comparing(job -> jobScores[jobs.indexOf(job)]));
        return jobs;
    }

    public static List<Applicant> sortApplicants(List<Applicant> applicants, JobPost job) {
        // Create a document for each applicant and the job
        List<String> jobDocument = createDocument(job);
        List<List<String>> applicantDocuments = new ArrayList<>();
        for (Applicant applicant : applicants) {
            applicantDocuments.add(createDocument(applicant));
        }

        // Create a vocabulary of all the unique words from the documents
        List<String> vocabulary = createVocabulary(jobDocument, applicantDocuments);

        // For each word in the document, find its TF-IDF score,
        // and assign the score to the corresponding position in the vector.
        Double[] jobVector = createVector(jobDocument, vocabulary);
        Double[] applicantScores = new Double[applicants.size()];
        for (int i = 0; i < applicants.size(); i++) {
            Double[] applicantVector = createVector(applicantDocuments.get(i), vocabulary);

            // Calculate the cosine similarity between the document vector and the query vector
            applicantScores[i] = cosineSimilarity(jobVector, applicantVector);
        }

        // Sort the documents by their cosine similarity score
        applicants.sort(Comparator.comparing(applicant -> applicantScores[applicants.indexOf(applicant)]));
        return applicants;
    }

    private static Double cosineSimilarity(Double[] vectorA, Double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    private static Double[] createVector(List<String> document, List<String> vocabulary) {
        Double[] vector = new Double[vocabulary.size()];
        for (int i = 0; i < vocabulary.size(); i++) {
            vector[i] = 0.0;
        }

        for (String word : document) {
            int index = vocabulary.indexOf(word);
            if (index != -1) {
                vector[index] = TFIDF.getScore(document, vocabulary, word);
            }
        }

        return vector;
    }

    private static List<String> createVocabulary(List<String> document, List<List<String>> documents) {
        ArrayList<String> vocabulary = new ArrayList<>(document);
        for (List<String> jobDocument : documents) {
            vocabulary.addAll(jobDocument);
        }

        String documentAsString = String.join(" ", vocabulary);
        return Stream.of(documentAsString.split(" ")).distinct().toList();
    }

    private static List<String> createDocument(Applicant applicant) {
        ArrayList<String> document = new ArrayList<>();

        document.add(applicant.getTitle());
        document.add(applicant.getExperienceLevel().getName());
        document.add(applicant.getPreferLocation().getCity());
        document.add(applicant.getPreferJobType().getName());
        document.add(applicant.getPreferIndustry().getName());

        for (ApplicantEducation education : applicant.getApplicantEducations()) {
            document.add(education.getDegree().getName());
            document.add(education.getMajor().getName());
        }

        for (ApplicantExperience experience : applicant.getApplicantExperiences()) {
            document.add(experience.getTitle());
            document.add(experience.getAccomplishment());
            document.add(experience.getExperienceLevel().getName());
        }

        for (ApplicantSkill skill : applicant.getApplicantSkills()) {
            document.add(skill.getSkill());
        }

        String documentAsString = String.join(" ", document);
        documentAsString = documentAsString.replaceAll("[^a-zA-Z0-9\\s]", "");
        documentAsString = documentAsString.replaceAll("\\s+", " ");
        return List.of(documentAsString.split(" "));
    }

    private static List<String> createDocument(JobPost job) {
        ArrayList<String> document = new ArrayList<>();

        document.add(job.getRecruiter().getOrganization().getDescription());
        document.add(job.getRecruiter().getOrganization().getLocation().getCity());
        document.add(job.getRecruiter().getOrganization().getIndustry().getName());

        document.add(job.getTitle());
        document.add(job.getDescription());
        document.add(job.getJobType().getName());

        for (JobRequireDegree degree : job.getJobRequireDegrees()) {
            document.add(degree.getDegree().getName());
        }

        for (JobRequireMajor major : job.getJobRequireMajors()) {
            document.add(major.getMajor().getName());
        }

        for (JobRequireSkill skill : job.getJobRequireSkills()) {
            document.add(skill.getSkill());
        }

        for (JobRequireExperienceLevel experienceLevel : job.getJobRequireExperienceLevels()) {
            document.add(experienceLevel.getExperienceLevel().getName());
        }

        String documentAsString = String.join(" ", document);
        documentAsString = documentAsString.replaceAll("[^a-zA-Z0-9\\s]", "");
        documentAsString = documentAsString.replaceAll("\\s+", " ");
        return List.of(documentAsString.split(" "));
    }
}
