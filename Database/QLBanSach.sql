Create DATABASE QL_BanSach
go

USE QL_BanSach
go

CREATE TABLE DANHMUC
(
	ID_DanhMuc int identity (1,1) PRIMARY KEY,
	TenDM nvarchar(50)
)
go
CREATE TABLE THELOAI
(
	ID_TheLoai int identity (1,1) PRIMARY KEY,
	TenTL nvarchar(50),
	MoTa nvarchar(500),
	DanhMuc int
)
go
CREATE TABLE SACH
(
	ID_Sach int identity (1,1) PRIMARY KEY,
	TenSach nvarchar(50),
	DonGia money,
	SoLuong int check (SoLuong>=0),
	TacGia nvarchar(50),
	NXB nvarchar(50),
	TheLoai int,
	HinhAnh nvarchar(50)
)
go
CREATE TABLE ACCOUNT
(
	ID_Account int identity (1,1) PRIMARY KEY,
	UserName varchar(20),
	Pass varchar(20),
	TrangThai bit default 1,
	Loai bit
)
go

CREATE TABLE KHACHHANG
(
	ID_KhachHang int identity (1,1) PRIMARY KEY,
	TenKH nvarchar(50),
	SDT varchar(13),
	Email varchar(50),
	GioiTinh bit,
	Account int
)
go

CREATE TABLE DONHANG
(
	ID_DonHang int identity (1,1) PRIMARY KEY,
	NguoiNhan nvarchar(50),
	SDTNguoiNhan varchar(13),
	DiaChiNhan nvarchar(50),
	NgayDatHang datetime,
	GhiChu nvarchar(200),
	TrangThai int default 0,
	TongTien money,
	KH int
)
go

CREATE TABLE CT_DONHANG
(
	ID_DonHang int,
	ID_Sach int,
	SoLuong int check (SoLuong>0),
	PRIMARY KEY (ID_DonHang, ID_Sach)
)
go

ALTER TABLE THELOAI
ADD CONSTRAINT FK_THELOAI_DANHMUC
FOREIGN KEY (DanhMuc)
REFERENCES DANHMUC(ID_DanhMuc)

ALTER TABLE SACH
ADD CONSTRAINT FK_SACH_THELOAI
FOREIGN KEY (TheLoai)
REFERENCES THELOAI(ID_TheLoai)

ALTER TABLE KHACHHANG
ADD CONSTRAINT FK_KHACHHANG_ACCOUNT
FOREIGN KEY (Account)
REFERENCES ACCOUNT(ID_Account)

ALTER TABLE DONHANG
ADD CONSTRAINT FK_DONHANG_KHACHHANG
FOREIGN KEY (KH)
REFERENCES KHACHHANG(ID_KhachHang)

ALTER TABLE CT_DONHANG
ADD CONSTRAINT FK_CT_DONHANG_DONHANG
FOREIGN KEY (ID_DonHang)
REFERENCES DONHANG(ID_DonHang)

ALTER TABLE CT_DONHANG
ADD CONSTRAINT FK_CT_DONHANG_SACH
FOREIGN KEY (ID_Sach)
REFERENCES SACH(ID_Sach)