# TindIn Job Boards

**Data model**: https://dbdiagram.io/d/6436d9378615191cfa8d69a1

<details>
   <summary><b>API endpoints</b></summary>
   <table>
      <thead>
         <tr>
            <th>Phương thức</th>
            <th>Đường dẫn</th>
            <th>Chức năng</th>
            <th>Phân công</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td>POST</td>
            <td>api/auth</td>
            <td>Đăng nhập và trả về một token chứa ID và role của người dùng</td>
            <td>Nguyên</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/applicants</td>
            <td>Lấy danh sách ứng viên. Dùng cho nhà tuyển dụng tìm ứng viên</td>
            <td>Oanh</td>
         </tr>
         <tr>
            <td>POST</td>
            <td>api/applicants</td>
            <td>Tạo tài khoản ứng viên mới</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/applicants/:id</td>
            <td>Lấy thông tin chi tiết của một ứng viên</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>PUT</td>
            <td>api/applicants/:id</td>
            <td>Cập nhập thông tin ứng viên</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/applicants/:id/jobs</td>
            <td>Ứng viên xem lại danh sách công việc mà mình quan tâm</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>POST</td>
            <td>api/recruiters</td>
            <td>Tạo tài khoản nhà tuyển dụng mới</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/recruiters/:id</td>
            <td>Lấy thông tin chi tiết của nhà tuyển dụng</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>PUT</td>
            <td>api/recruiters/:id</td>
            <td>Cập nhập thông tin nhà tuyển dụng</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/recruiters/:id/jobs</td>
            <td>Nhà tuyển dụng xem lại danh sách công việc mà mình đã tạo</td>
            <td>Long</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/jobs</td>
            <td>Người tìm việc có thể xem danh sách công việc phù hợp với mình</td>
            <td>Oanh</td>
         </tr>
         <tr>
            <td>POST</td>
            <td>api/jobs</td>
            <td>Nhà tuyển dụng có quyền tạo tin tuyển dụng mới</td>
            <td>Bích</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/jobs/:id</td>
            <td>Xem thông tin tuyển dụng chi tiết</td>
            <td>Bích</td>
         </tr>
         <tr>
            <td>POST</td>
            <td>api/jobs/:id</td>
            <td>Ứng viên &quot;quan tâm&quot; công việc, hoặc nhà tuyển dụng &quot;duyệt&quot; ứng viên</td>
            <td>Oanh</td>
         </tr>
         <tr>
            <td>PUT</td>
            <td>api/jobs/:id</td>
            <td>Nhà tuyển dụng có quyền cập nhập tin tuyển dụng</td>
            <td>Bích</td>
         </tr>
         <tr>
            <td>DELETE</td>
            <td>api/jobs/:id</td>
            <td>Ứng viên hủy &quot;quan tâm&quot; công việc, hoặc nhà tuyển dụng hủy &quot;duyệt&quot;</td>
            <td>Oanh</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/jobs/:id/applications</td>
            <td>Nhà tuyển dụng có quyền xem danh sách ứng viên &quot;quan tâm&quot; hoặc được &quot;duyệt&quot;</td>
            <td>Oanh</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/jobs/:id/recommended</td>
            <td>Nhà tuyển dụng có quyền xem danh sách ứng viên gợi ý</td>
            <td>Oanh</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/organizations</td>
            <td>Xem danh sách doanh nghiệp. Dùng để cho ứng viên tìm kiểm</td>
            <td>Oanh</td>
         </tr>
         <tr>
            <td>POST</td>
            <td>api/organizations</td>
            <td>Tạo mới doanh nghiệp. Dùng khi cập nhập hồ sơ</td>
            <td>Bích</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/organizations/:id</td>
            <td>Xem thông tin của doanh nghiệp</td>
            <td>Bích</td>
         </tr>
         <tr>
            <td>PUT</td>
            <td>api/organizations/:id</td>
            <td>Nhà tuyển dụng có thể cập nhập thông tin của doanh nghiệp của mình</td>
            <td>Bích</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/organizations/:id/jobs</td>
            <td>Xem thông tin việc làm của doanh nghiệp</td>
            <td>Bích</td>
         </tr>
         <tr>
            <td>GET</td>
            <td>api/suggestion</td>
            <td>Gợi ý các thông tin lặt vặt trong lúc nhập thông tin trong Datalist</td>
            <td>Nguyên</td>
         </tr>
      </tbody>
   </table>
</details>

Gợi ý công việc cho ứng viên, cũng như ứng viên cho từng công việc, sẽ dựa vào các yếu tố sau, với độ quan trọng giảm dần. Cần lưu ý tính điểm để sắp xếp.

- Có cùng các loại kỹ năng với mức độ tương ứng. Lưu ý cấp độ của mỗi kỹ năng
- Cùng title và experience với công việc đã làm trước đó, VD: Senior Software Engineering,...
- Thời gian làm việc tại các vị trí trước đó (Càng lâu càng tốt)

- Loại công việc - JobType, VD: thực tập, toàn thời gian, hợp đồng,...
- jobTitle và experienceLevel của ứng viên
- Địa điểm làm việc - Location
- Mức lương tương đương - Salary
- Yêu cầu về bằng cấp và ngành học
- Cùng lĩnh vực làm việc với công ty - Industry, VD: IT, ngân hàng, ...
