-- V7__insert_page_sections.sql
-- Seed data for page_sections (pages 15, 18, 20)

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(22, '2026-05-31 10:02:59.862964', '2026-05-31 10:02:59.893081', true,
 '[{"icon": "", "text": "Để đảm bảo an toàn vận chuyển và tuân thủ quy định pháp luật, một số nhóm hàng hoá không được phép nhập khẩu hoặc bị hạn chế đặc biệt. Khách hàng cần kiểm tra kỹ trước khi đặt mua.", "type": "text", "headers": null, "cellRows": null, "boldParts": null}]',
 '[]', 1, '[{"icon": "", "text": "Nguyên tắc chung", "type": "text"}]', 18);

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(23, '2026-05-31 10:07:25.048473', '2026-05-31 10:07:25.056907', true,
 '[{"icon": null, "text": null, "type": "table", "headers": ["Nhóm hàng", "Ví dụ", "Trạng thái"], "cellRows": [[{"text": "Vũ khí, vật liệu nổ", "colspan": null, "rowspan": null, "startRow": 0}, {"text": "Súng, đạn, pháo nổ, chất kích nổ", "colspan": null, "rowspan": null, "startRow": 0}, {"text": "Cấm tuyệt đối", "colspan": null, "rowspan": null, "startRow": 0}, {"text": "Chất gây nghiện", "colspan": null, "rowspan": null, "startRow": 1}, {"text": "Ma tuý, tiền chất ma tuý", "colspan": null, "rowspan": null, "startRow": 1}, {"text": "Cấm tuyệt đối", "colspan": null, "rowspan": null, "startRow": 1}, {"text": "Văn hoá phẩm bị cấm", "colspan": null, "rowspan": null, "startRow": 2}, {"text": "Nội dung phản cảm, chống phá, vi phạm pháp luật", "colspan": null, "rowspan": null, "startRow": 2}, {"text": "Cấm tuyệt đối", "colspan": null, "rowspan": null, "startRow": 2}, {"text": "Hóa chất độc hại", "colspan": null, "rowspan": null, "startRow": 3}, {"text": "Chất ăn mòn, chất độc mạnh chưa được cấp phép", "colspan": null, "rowspan": null, "startRow": 3}, {"text": "Hạn chế / cần giấy phép", "colspan": null, "rowspan": null, "startRow": 3}]], "boldParts": null}]',
 '[]', 2, '[{"icon": "", "text": "Danh mục hàng hoá cấm phổ biến", "type": "text"}]', 18);

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(24, '2026-05-31 10:13:19.533680', '2026-05-31 10:13:19.538969', true,
 '[{"icon": "", "text": "Pin lithium công suất lớn, thiết bị có nam châm mạnh.", "type": "text-bullet", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Mỹ phẩm, thực phẩm chức năng, thuốc và thiết bị y tế.", "type": "text-bullet", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Sản phẩm có bản quyền, thương hiệu, logo nhạy cảm.", "type": "text-bullet", "headers": [], "cellRows": [], "boldParts": null}]',
 '[]', 3, '[{"icon": "", "text": "Nhóm hàng cần kiểm tra trước khi gửi", "type": "text"}]', 18);

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(25, '2026-05-31 10:15:01.154856', '2026-05-31 10:15:01.160710', true,
 '[{"icon": "", "text": "Gửi link sản phẩm cho CSKH để được kiểm tra trước khi tạo đơn.", "type": "text-number", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Không khai báo sai tên hàng hoặc giá trị hàng hoá.", "type": "text-number", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Chuẩn bị chứng từ bổ sung nếu hàng thuộc nhóm kiểm soát.", "type": "text-bullet", "headers": [], "cellRows": [], "boldParts": null}]',
 '[]', 4, '[{"icon": "", "text": "Khuyến nghị cho khách hàng", "type": "text"}]', 18);

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(26, '2026-05-31 10:16:42.750924', '2026-05-31 10:16:42.758963', true,
 '[{"icon": "", "text": "Chính sách khiếu nại", "type": "quick-link", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Danh sách bảo mật thông tin", "type": "quick-link", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Danh mục hàng hóa cấm nhập khẩu", "type": "quick-link", "headers": [], "cellRows": [], "boldParts": null}]',
 '[]', 1, '[{"icon": "", "text": "Danh mục chính sách", "type": "text"}]', 15);

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(27, '2026-05-31 10:21:18.707122', '2026-05-31 10:21:18.710275', true,
 '[{"icon": "", "text": "Mọi chính sách được áp dụng minh bạch theo từng loại dịch vụ và từng thời điểm cập nhật.", "type": "notes", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Nếu có điểm chưa rõ, vui lòng liên hệ CSKH để được giải thích trước khi tạo đơn.", "type": "notes", "headers": [], "cellRows": [], "boldParts": null}]',
 '[]', 1, '[{"icon": "", "text": "Lưu ý thực thi", "type": "text"}]', 15);

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(28, '2026-05-31 10:50:56.738689', '2026-05-31 10:50:56.745681', true,
 '[{"icon": "", "text": "Điểm mặt qua những thương hiệu mỹ phẩm nổi tiếng như L''OREAL, OLAY, SK-II, …", "type": "text", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Để tham khảo giá các sản phẩm đợt sale này của L''OREAL, truy cập trực tiếp vào đường dẫn của thương hiệu này tại đây.", "type": "text", "headers": [], "cellRows": [], "boldParts": null}, {"icon": "", "text": "Hàng loạt các loại mỹ phẩm từ kem dưỡng da, kem chống nhăn, nước tẩy trang, son môi dành cho phái đẹp tới các sản phẩm dành cho đấng mày râu.", "type": "text", "headers": [], "cellRows": [], "boldParts": null}]',
 '[]', 1, '[]', 20);

INSERT INTO page_sections (id, created_at, updated_at, active, description, images, sort_index, title, page_id) VALUES
(29, '2026-05-31 10:55:59.155636', '2026-05-31 10:55:59.186797', true,
 '[{"img": "https://haitau.vn/wp-content/uploads/2019/03/loreal-my-pham-sale-2.jpg", "icon": "", "text": "Các sản phẩm sale hot ngày 8/3", "type": "text-img", "headers": [], "cellRows": [], "boldParts": null}, {"img": "https://haitau.vn/wp-content/uploads/2019/03/loreal-my-pham-sale-3.jpg", "icon": "", "text": "Hàng loạt kem chống nắng, kem dưỡng da Loreal sale hấp dẫn", "type": "text-img", "headers": [], "cellRows": [], "boldParts": null}]',
 '[]', 2, '[]', 20);
