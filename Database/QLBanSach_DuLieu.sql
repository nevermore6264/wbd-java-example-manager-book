USE QL_BanSach
go

-- Danh mục
INSERT INTO DANHMUC VALUES (N'Sách chuyên ngành')
INSERT INTO DANHMUC VALUES (N'Truyện')
INSERT INTO DANHMUC VALUES (N'Sách ngoại ngữ')

-- Thể loại thuộc danh mục Sách chuyên ngành
INSERT INTO THELOAI VALUES (N'Tin học', N'abc', 1)
INSERT INTO THELOAI VALUES (N'Kinh tế', N'abc', 1)
INSERT INTO THELOAI VALUES (N'Văn học', N'abc', 1)
-- Thể loại thuộc danh mục Truyện
INSERT INTO THELOAI VALUES (N'Truyện Tranh', N'abc', 2)
INSERT INTO THELOAI VALUES (N'Truyện thiếu nhi', N'abc', 2)
INSERT INTO THELOAI VALUES (N'Truyện ngôn tình', N'abc', 2)
-- Thể loại thuộc danh mục Sách ngoại ngữ
INSERT INTO THELOAI VALUES (N'Tiếng Anh', N'abc', 3)
INSERT INTO THELOAI VALUES (N'Tiếng Nhật', N'abc', 3)
INSERT INTO THELOAI VALUES (N'Tiếng Hàn', N'abc', 3)

-- Sách thuộc thể loại Tin học
INSERT INTO SACH VALUES (N'Tin học cơ bản', 40000, 10, N'TacGia', N'NXB', 1,'product-1.png')
INSERT INTO SACH VALUES (N'Tin học văn phòng', 40000, 10, N'TacGia', N'NXB', 1,'product-1.png')
INSERT INTO SACH VALUES (N'Hướng dẫn cài hệ điều hành', 40000, 10, N'TacGia', N'NXB', 1,'product-1.png')
INSERT INTO SACH VALUES (N'Lập trình căn bản với pascal', 40000, 10, N'TacGia', N'NXB', 1,'product-1.png')
-- Sách thuộc thể loại Kinh tế
INSERT INTO SACH VALUES (N'Kinh tế học', 30000, 10, N'TacGia', N'NXB', 2,'product-2.png')
INSERT INTO SACH VALUES (N'Quản lý tài chính 1', 40000, 10, N'TacGia', N'NXB', 2,'product-2.png')
INSERT INTO SACH VALUES (N'Thị trường chứng khoán', 40000, 10, N'TacGia', N'NXB', 2,'product-2.png')
INSERT INTO SACH VALUES (N'Kinh tế thị trường', 40000, 10, N'TacGia', N'NXB', 2,'product-2.png')
INSERT INTO SACH VALUES (N'Kinh tế vi mô', 40000, 10, N'TacGia', N'NXB', 2,'product-2.png')
-- Sách thuộc thể loại Văn học
INSERT INTO SACH VALUES (N'Truyện Kiều', 40000, 10, N'TacGia', N'NXB', 3,'product-3.png')
INSERT INTO SACH VALUES (N'Tắt đèn', 40000, 10, N'TacGia', N'NXB', 3,'product-3.png')
INSERT INTO SACH VALUES (N'Nhật ký trong tù', 40000, 10, N'TacGia', N'NXB', 3,'product-3.png')
INSERT INTO SACH VALUES (N'Lão Hạc', 40000, 10, N'TacGia', N'NXB', 3,'product-3.png')
INSERT INTO SACH VALUES (N'Vợ chồng A Phủ', 40000, 10, N'TacGia', N'NXB', 3,'product-3.png')
-- Sách thuộc thể loại Truyện tranh
INSERT INTO SACH VALUES (N'Conan', 30000, 10, N'TacGia', N'NXB', 4,'product-4.png')
INSERT INTO SACH VALUES (N'Doraemon', 30000, 10, N'TacGia', N'NXB', 4,'product-4.png')
INSERT INTO SACH VALUES (N'Đảo hải tặc', 40000, 10, N'TacGia', N'NXB', 4,'product-4.png')
INSERT INTO SACH VALUES (N'Trạng Quỳnh', 40000, 10, N'TacGia', N'NXB', 4,'product-4.png')
INSERT INTO SACH VALUES (N'Naruto', 40000, 10, N'TacGia', N'NXB', 4,'product-4.png')
-- Sách thuộc thể loại Truyện thiếu nhi
INSERT INTO SACH VALUES (N'Hoàng tử rơm', 40000, 10, N'TacGia', N'NXB', 5,'product-5.png')
INSERT INTO SACH VALUES (N'Giải cứu trực thăng', 40000, 10, N'TacGia', N'NXB', 5,'product-5.png')
INSERT INTO SACH VALUES (N'Nàng tiên cá học bơi', 40000, 10, N'TacGia', N'NXB', 5,'product-5.png')
INSERT INTO SACH VALUES (N'Hành tin kì lạ', 40000, 10, N'TacGia', N'NXB', 5,'product-5.png')
INSERT INTO SACH VALUES (N'Mùa bay', 40000, 10, N'TacGia', N'NXB', 5,'product-5.png')
-- Sách thuộc thể loại Truyện ngôn tình
INSERT INTO SACH VALUES (N'Dạ hành ca', 40000, 10, N'TacGia', N'NXB', 6,'product-6.png')
INSERT INTO SACH VALUES (N'Chí tôn hắc y', 40000, 10, N'TacGia', N'NXB', 6,'product-6.png')
INSERT INTO SACH VALUES (N'Lãnh hoàng phế hậu', 40000, 10, N'TacGia', N'NXB', 6,'product-6.png')
INSERT INTO SACH VALUES (N'Nhật ký bá chủ học đường', 40000, 10, N'TacGia', N'NXB', 6,'product-6.png')
INSERT INTO SACH VALUES (N'Nhân gian hoan hỉ', 40000, 10, N'TacGia', N'NXB', 6,'product-6.png')
-- Sách thuộc thể loại Tiếng Anh
INSERT INTO SACH VALUES (N'Luyện ngữ pháp', 30000, 10, N'TacGia', N'NXB', 7,'product-7.png')
INSERT INTO SACH VALUES (N'Hướng dẫn phát âm', 30000, 10, N'TacGia', N'NXB', 7,'product-7.png')
INSERT INTO SACH VALUES (N'Luyện thi Ielts', 40000, 10, N'TacGia', N'NXB', 7,'product-7.png')
INSERT INTO SACH VALUES (N'Tự học Ielts', 40000, 10, N'TacGia', N'NXB', 7,'product-7.png')
INSERT INTO SACH VALUES (N'Luyện thi Toeic', 40000, 10, N'TacGia', N'NXB', 7,'product-7.png')
INSERT INTO SACH VALUES (N'Tự học Toeic', 40000, 10, N'TacGia', N'NXB', 7,'product-7.png')
-- Sách thuộc thể loại Tiếng Nhật
INSERT INTO SACH VALUES (N'Ngữ pháp tiếng Nhật', 40000, 10, N'TacGia', N'NXB', 8,'product-8.png')
INSERT INTO SACH VALUES (N'Học giao tiếp tiếng Nhật', 40000, 10, N'TacGia', N'NXB', 8,'product-8.png')
INSERT INTO SACH VALUES (N'Từ điển Nhật-Việt', 40000, 10, N'TacGia', N'NXB', 8,'product-8.png')
INSERT INTO SACH VALUES (N'Tiếng Nhật thông dụng', 40000, 10, N'TacGia', N'NXB', 8,'product-8.png')
INSERT INTO SACH VALUES (N'Luyện thi N4', 40000, 10, N'TacGia', N'NXB', 8,'product-8.png')
INSERT INTO SACH VALUES (N'Luyện thi N5', 40000, 10, N'TacGia', N'NXB', 8,'product-8.png')
-- Sách thuộc thể loại Tiếng Hàn
INSERT INTO SACH VALUES (N'Học viết tiếng Hàn', 30000, 10, N'TacGia', N'NXB', 9,'product-9.png')
INSERT INTO SACH VALUES (N'Học giao tiếp tiếng Hàn', 30000, 10, N'TacGia', N'NXB', 9,'product-9.png')
INSERT INTO SACH VALUES (N'Luyện thi tiếng Hàn', 40000, 10, N'TacGia', N'NXB', 9,'product-9.png')
-- Account khách hàng
INSERT INTO ACCOUNT VALUES ('a','123', 1, 0)
INSERT INTO ACCOUNT VALUES ('b','123', 1, 0)
INSERT INTO ACCOUNT VALUES ('c','123', 1, 0)
INSERT INTO ACCOUNT VALUES ('d','123', 1, 0)
INSERT INTO ACCOUNT VALUES ('e','123', 1, 0)
INSERT INTO ACCOUNT VALUES ('f','123', 1, 0)
-- Account quản lý
INSERT INTO ACCOUNT VALUES ('admin','123', 1, 1)


-- Khách hàng
INSERT INTO KHACHHANG VALUES (N'Nguyễn Văn A','01234567890', 'a@gmail.com', 1, 1)
INSERT INTO KHACHHANG VALUES (N'Nguyễn Văn B','01234567899', 'b@gmail.com', 1, 2)
INSERT INTO KHACHHANG VALUES (N'Nguyễn Văn C','01234567898', 'c@gmail.com', 0, 3)
INSERT INTO KHACHHANG VALUES (N'Nguyễn Văn D','01234567894', 'd@gmail.com', 1, 4)
INSERT INTO KHACHHANG VALUES (N'Nguyễn Văn E','01234567893', 'e@gmail.com', 1, 5)
INSERT INTO KHACHHANG VALUES (N'Nguyễn Văn F','01234567892', 'f@gmail.com', 0, 6)

-- Đơn hàng
INSERT INTO DONHANG VALUES (N'Nguyễn Văn A','01234567897', N'35,Lê Đức Thọ,Nam Từ Liêm,Hà Nội', getdate(), null, 0, 40000,1)
INSERT INTO DONHANG VALUES (N'Nguyễn Văn B','01234567896', N'29,Văn Tiến Dũng,Bắc Từ Liêm,Hà Nội', getdate(), null, 0, 40000,2)
INSERT INTO DONHANG VALUES (N'Nguyễn Văn C','01234567895', N'120,Phạm Văn Đồng,Mai Dịch,Hà Nội', getdate(), null, 0, 40000,2)
-- Chi tiết đơn hàng
INSERT INTO CT_DONHANG VALUES (1, 2, 1)
INSERT INTO CT_DONHANG VALUES (2, 10, 2)
INSERT INTO CT_DONHANG VALUES (3, 11, 2)