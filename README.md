# TindIn Job Boards Server

Máy chủ truy xuất dữ liệu từ cơ sở dữ liệu thông qua các REST API. _Đây là
[một phần](https://github.com/minhlong149/tindin-client) đồ án xây dựng trang tìm kiếm việc làm cho
môn học Công nghệ Java của nhóm sinh viên trường Đại học Công nghệ Thông tin -
ĐHQG TP.HCM._

- [TindIn Job Boards Server](#tindin-job-boards-server)
  - [Thiết kế dữ liệu](#thiết-kế-dữ-liệu)
  - [Thuật toán gợi ý](#thuật-toán-gợi-ý)
  - [Kiến trúc hệ thống](#kiến-trúc-hệ-thống)
  - [Thiết kế API](#thiết-kế-api)
  - [Hướng dẫn cài đặt](#hướng-dẫn-cài-đặt)
  - [Tác giả](#tác-giả)

## Thiết kế dữ liệu

> Chi tiết mô hình cơ sở dữ liệu được mô tả tại: <https://dbdiagram.io/d/6436d9378615191cfa8d69a1>

- Mỗi người dùng chỉ có một tài khoản đăng nhập duy nhất.
- Người dùng có thể là **ứng viên** hoặc **nhà tuyển dụng** hoặc cả hai.
- Mỗi ứng viên có thể có nhiều thông tin về học vấn, kinh nghiệm, kỹ năng và hoạt động ứng tuyển.
- Mỗi tổ chức có thể có nhiều người tuyển dụng. Mỗi người tuyển dụng có thể đăng nhiều bài tuyển dụng cho tổ chức của mình.
- Mỗi bài đăng tuyển dụng có thể có nhiều yêu cầu về bằng cấp, chuyên ngành, kinh nghiệm và kỹ năng.

## Thuật toán gợi ý

- Để sắp xếp các công việc phù hợp với ứng viên, hệ thống đã sử dụng **TF-IDF** và **Cosine Similarity** để tính toán độ tương đồng giữa các văn bản.
  - TF-IDF (Term Frequency-Inverse Document Frequency) là một kỹ thuật xử lý ngôn ngữ tự nhiên để đánh giá tầm quan trọng của một từ trong một văn bản, dựa trên số lần xuất hiện của từ đó trong văn bản và trong toàn bộ tập văn bản.
  - Cosine Similarity là một phép đo khoảng cách góc giữa hai vector, có thể được sử dụng để so sánh độ giống nhau của hai văn bản sau khi chuyển đổi chúng thành các vector TF-IDF.

- Bằng cách áp dụng TF-IDF và Cosine Similarity cho các công việc và các hồ sơ ứng viên, hệ thống có thể xếp hạng các công việc theo thứ tự giảm dần của độ tương đồng và hiển thị cho người dùng những công việc phù hợp nhất với họ.

- Gợi ý công việc cho ứng viên, cũng như ứng viên cho từng công việc, sẽ dựa vào các yếu tố sau, với độ quan trọng giảm dần:
  - Có cùng các loại kỹ năng với mức độ tương ứng.
  - Có cùng chức vụ và kinh nghiệm với công việc đã làm trước đó.
  - Yêu cầu về loại công việc, địa điểm, mức lương lĩnh vực làm việc, bằng cấp và ngành học,...

## Kiến trúc hệ thống

- Máy chủ sử dụng **Java Spring Boot** sẽ nhận các yêu cầu từ máy khách, xử lý các yêu cầu logic nghiệp vụ theo các chức năng của trang web, giao tiếp với cơ sở dữ liệu để lưu trữ hoặc truy xuất các dữ liệu cần thiết, và trả về các dữ liệu hoặc kết quả xử lý cho máy khách. Server được đóng gói và chạy trong một **container Docker** để đảm bảo tính nhất quán và khả năng di chuyển.

- **PostgreSQL** chạy trên máy chủ **Supabase** được sử dụng để lưu trữ và quản lý các dữ liệu của trang web, bao gồm thông tin về người dùng, công việc, ứng viên và gợi ý. Cơ sở dữ liệu này sẽ nhận các yêu cầu từ máy chủ, thực hiện các thao tác với các bảng và dòng dữ liệu và trả về dữ liệu cho máy chủ.

- Để bảo mật thông tin đăng nhập của người dùng, **JWT** và **Bcrypt** cũng được sử dụng để mã hóa mật khẩu tài khoản người dùng và tạo ra các token xác thực cho mỗi phiên đăng nhập.

## Thiết kế API

| ****Phương thức**** | ****Đường dẫn****            | ****Chức năng****                                                           |
|---------------------|------------------------------|-----------------------------------------------------------------------------|
| POST                | api/auth/                    | Đăng nhập và trả về một token chứa ID và role của người dùng                |
| GET                 | api/applicants               | Lấy danh sách ứng viên. Dùng cho nhà tuyển dụng tìm ứng viên                |
| POST                | api/applicants               | Tạo tài khoản ứng viên mới                                                  |
| GET                 | api/applicants/`:id`         | Lấy thông tin chi tiết của một ứng viên                                     |
| PUT                 | api/applicants/`:id`         | Cập nhập thông tin ứng viên                                                 |
| GET                 | api/applicants/`:id`/jobs    | Ứng viên xem lại danh sách công việc mà mình quan tâm                       |
| POST                | api/recruiters               | Tạo tài khoản nhà tuyển dụng mới                                            |
| GET                 | api/recruiters/`:id`         | Lấy thông tin chi tiết của nhà tuyển dụng                                   |
| PUT                 | api/recruiters/`:id`         | Cập nhập thông tin nhà tuyển dụng                                           |
| GET                 | api/recruiters/`:id`/jobs    | Nhà tuyển dụng xem lại danh sách công việc mà mình đã tạo                   |
| GET                 | api/jobs                     | Người tìm việc có thể xem danh sách công việc phù hợp với mình              |
| POST                | api/jobs                     | Nhà tuyển dụng có quyền tạo tin tuyển dụng mới                              |
| GET                 | api/jobs/`:id`               | Xem thông tin tuyển dụng chi tiết                                           |
| POST                | api/jobs/`:id`               | Ứng viên "quan tâm" công việc, hoặc nhà tuyển dụng "duyệt" ứng viên         |
| PUT                 | api/jobs/`:id`               | Nhà tuyển dụng có quyền cập nhập tin tuyển dụng                             |
| DELETE              | api/jobs/`:id`               | Ứng viên hủy "quan tâm" công việc, hoặc nhà tuyển dụng hủy "duyệt"          |
| GET                 | api/jobs/`:id`/applications  | Nhà tuyển dụng có quyền xem danh sách ứng viên "quan tâm" hoặc được "duyệt" |
| GET                 | api/jobs/`:id`/recommended   | Nhà tuyển dụng có quyền xem danh sách ứng viên gợi ý                        |
| GET                 | api/organizations            | Xem danh sách doanh nghiệp. Dùng để cho ứng viên tìm kiểm                   |
| POST                | api/organizations            | Tạo mới doanh nghiệp. Dùng khi cập nhập hồ sơ                               |
| GET                 | api/organizations/`:id`      | Xem thông tin của doanh nghiệp                                              |
| PUT                 | api/organizations/`:id`      | Nhà tuyển dụng có thể cập nhập thông tin của doanh nghiệp của mình          |
| GET                 | api/organizations/`:id`/jobs | Xem thông tin việc làm của doanh nghiệp                                     |
| GET                 | api/suggestion               | Gợi ý các thông tin lặt vặt trong lúc nhập thông tin trong Datalist         |

## Hướng dẫn cài đặt

- Chuẩn bị một máy chủ cơ sở dữ liệu PostgreSQL. Có thể sử dụng máy chủ cơ sở dữ liệu miễn phí trên [Supabase](https://supabase.io/).
- Thêm vào các biến môi trường `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USER`, `DB_PASSWORD` và `JWT_SECRET_KEY` để kết nối với máy chủ cơ sở dữ liệu và tạo ra các token xác thực.
- Khởi chạy máy chủ thông qua lệnh `mvn spring-boot:run`, hoặc bằng cách chạy `Dockerfile` thông qua tập tin `.jar` đã được đóng gói.

## Tác giả

- [Nguyễn Đào Minh Long](https://github.com/minhlong149) - Quản lý thông tin tài khoản ứng viên và nhà tuyển dụng. Xây dựng thuật toán gợi ý công việc và ứng viên phù hợp.
- [Trần Trọng Nguyên](https://github.com/Norman-Tran) - Xây dựng chức năng đăng nhập và lấy về các thông tin nhập liệu.
- [Quách Kiều Oanh](https://github.com/Qanh195) - Truy xuất thông tin của ứng viên và tin tuyển dụng. Xây dựng chức năng ứng tuyển công việc.
- [Mai Ngọc Bích](https://github.com/bichmn) - Quản lý tin tuyển dụng và thông tin doanh nghiệp.
