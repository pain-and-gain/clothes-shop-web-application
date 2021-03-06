USE [PRJ301_SE1506_Assignment_Group6]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 7/12/2021 8:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[uID] [varchar](50) NOT NULL,
	[userName] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[isAdmin] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Category]    Script Date: 7/12/2021 8:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] NOT NULL,
	[cname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 7/12/2021 8:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[id] [int] NOT NULL,
	[orderId] [int] NOT NULL,
	[productId] [int] NOT NULL,
	[amount] [int] NOT NULL,
	[price] [money] NOT NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Orders]    Script Date: 7/12/2021 8:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Orders](
	[id] [int] NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[uID] [varchar](50) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](50) NOT NULL,
	[total] [float] NOT NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product]    Script Date: 7/12/2021 8:33:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[price] [money] NULL,
	[title] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[cateID] [int] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[Account] ([uID], [userName], [password], [isAdmin]) VALUES (N'admin', N'Thành', N'1', 1)
INSERT [dbo].[Account] ([uID], [userName], [password], [isAdmin]) VALUES (N'admin2', N'Thái', N'1', 1)
INSERT [dbo].[Account] ([uID], [userName], [password], [isAdmin]) VALUES (N'user', N'Chi', N'1', 0)
INSERT [dbo].[Category] ([cid], [cname]) VALUES (1, N'NIKE')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (2, N'ADIDAS')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (3, N'JORDAN')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (4, N'NIKE WOMEN')
INSERT [dbo].[OrderDetails] ([id], [orderId], [productId], [amount], [price]) VALUES (1, 1, 1, 3, 300.0000)
INSERT [dbo].[OrderDetails] ([id], [orderId], [productId], [amount], [price]) VALUES (2, 2, 2, 2, 200.0000)
INSERT [dbo].[OrderDetails] ([id], [orderId], [productId], [amount], [price]) VALUES (3, 3, 3, 4, 400.0000)
INSERT [dbo].[Orders] ([id], [email], [uID], [address], [phone], [total]) VALUES (1, N'abc@gmail.com', N'admin', N'Quận 10', N'093843829', 12)
INSERT [dbo].[Orders] ([id], [email], [uID], [address], [phone], [total]) VALUES (2, N'xyz@gmail.com', N'user', N'Quận 9', N'0965091952', 3)
INSERT [dbo].[Orders] ([id], [email], [uID], [address], [phone], [total]) VALUES (3, N'fgh@gmail.com', N'admin2', N'Quận 2', N'0956823923', 20)
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (1, N'Nike Sportswear Style Essentials', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/718d9e3b-8967-4c84-ab5f-955ad172cc78/sportswear-style-essentials-short-sleeve-t-shirt-KShdLM.png', 100.0000, N'NIKE', N'The Nike Sportswear Style Essentials T-Shirt rethinks an original.Made from at least 75% organic cotton fibres, its roomy fit features a non-traditional armhole design and a drop-tail hem for added coverage and comfort.A zipped pocket and signature details throughout help to separate this thoughtful silhouette from a classic tee.', 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (2, N'ADIDAS SPRT 3-STRIPES SPLIT TEE', N'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/402fb5e35ac6415587f6ad1000101ad2_9366/adidas_SPRT_3-Stripes_Split_Tee_Blue_H31275_21_model.jpg', 120.0000, N'ADIDAS', N'3-Stripes in contrast colours tell the world you are rolling with a community of rebels and rule-breakers. Show them off on this t-shirt and keep your adidas style authentic. Soft cotton feels cosy from the first wear to the millionth', 2)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (3, N'Nike iSPA', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5e5e1767-bf2c-456e-87ec-7bd933483b7e/ispa-adjustable-trousers-9cKKK7.png', 130.0000, N'NIKE', N'The world is constantly evolving.Keep up with the unexpected in the Nike iSPA Trousers.We crafted these using scavenged parts, like suede, tapes and reflective design elements, to create a garment for the surprises of today.An adjustable system helps give you the right fit.', 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (4, N'Jordan Jumpman Air', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/6e4b90ed-76ae-4c98-a749-71dd32622ede/jordan-jumpman-air-mens-short-sleeve-t-shirt-S15QBQ.png', 140.0000, N'JORDAN', N'Soak up the sun in the Jordan Jumpman Air T-Shirt. It''s made from soft, lightweight fabric with a refreshed seasonal graphic.', 3)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (5, N'Jordan Dri-FIT Zion', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/020c1a7a-6826-41ed-b760-9b4332d73368/jordan-dri-fit-zion-fleece-trousers-vLg2hr.png', 150.0000, N'JORDAN', N'Zion likes versatile clothing that he can wear while hanging with family and friends—and then go and hoop in.The Jordan Dri-FIT Zion Trousers tick all boxes, with smooth, sweat-wicking fleece and a design that''s fit for moving on and off the court.', 3)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (6, N'Women''s Nike Sportswear', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/66081912-f51f-4fee-802c-c40a5257916a/sportswear-womens-woven-pullover-jacket-ZZgppj.png', 160.0000, N'NIKE WOMEN', N'The Nike Sportswear Pullover Jacket is made with a lightweight woven fabric perfect for warmer-weather layering. An oversized fit and elastic cuffs and hem provide an effortless, casual feel.', 4)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (7, N'MANCHESTER UNITED 3-STRIPES TEE', N'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/1b2be254bf8145f281b5ad2800820f56_9366/Manchester_United_3-Stripes_Tee_Red_GR3895_25_model.jpg', 170.0000, N'NIKE', N'Manchester United DNA meets adidas 3-Stripes style in this football tee. Starring in red, black and white, its single jersey fabric feels soft against your skin. The embroidered team badge completes a look worthy of the club biggest supporters.', 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (9, N'Women''s Nike Sportswear Femme', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/65453ea2-9294-45dd-98ff-c37df3f8f663/sportswear-femme-womens-1-4-zip-pJz73w.png', 180.0000, N'NIKE WOMEN', N'Warm up your favorite summer silhouettes with the Nike Sportswear Femme 1/4-Zip. Its roomy fit is made with lightweight French terry fabric and a ribbed hem and cuffs for a carefree and comfortable feel.', 3)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (10, N'R.Y.V. TRACK PANTS', N'https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/9829d62764fc4c96b8ffac9f00c109b5_9366/R.Y.V._Track_Pants_Blue_GN3325_21_model.jpg', 180.0000, N'ADIDAS', N'The day is yours. Own it. Make a statement without saying a word in these R.Y.V. Track Pants. Grab your gear and go with pockets galore. Whatever happens next is your call. Soft cotton fabric lets you make power moves in complete comfort.', 2)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (11, N'Jordan Jumpman Diamond', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f32251c2-60d2-41e3-bae7-ac16599a3da5/jordan-jumpman-diamond-shorts-XNv8fQ.png', 150.0000, N'JORDAN', N'The Jordan Jumpman Diamond Shorts are inspired by a classic pro kit worn by Michael Jordan. Remade for easy, everyday wear, they''re made from lightweight fabric with taped overlays and premium Jumpman graphics.', 3)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (12, N'Nike x Stüssy', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/325304e1-4095-4641-97e5-47d5e6e73699/stussy-insulated-trousers-6hpSzh.png', 165.0000, N'NIKE', N'Cold weather doesn''t need to stop the good vibes. The Nike x Stüssy Trousers are relaxed and comfortable, with a main body fabric made from at least 75% recycled nylon and insulated with Thermore® Ecodown®, a down alternative made from 100% recycled polyester. Geared for cooler temperatures, the trousers can be paired with the Insulated Pullover Jacket for a tracksuit-inspired look.', 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (13, N'Nike Tempo Icon Clash', N'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/9270e842-9152-4b53-899e-47a784500cf5/tempo-icon-clash-running-shorts-Hlj1S0.png', 185.0000, N'NIKE WOMEN', N'Inspired by the natural wonders that surround us, the Nike Tempo Icon Clash Shorts come in earthy colours to keep you connected to the world as you rack up your miles.The lightweight and breezy design is made from 100% recycled polyester fibres.This product is made from 100% recycled polyester fibres.', 4)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (14, N'Áo Tập Gym Nữ Nike Thun 4 Chiều Tuyệt Đẹp', N'https://kiwisport.vn/wp-content/uploads/2020/03/ao-tap-gym-nu-nike-thun-co-gian-4-chieu.jpg', 120.0000, N'NIKE', N'Size áo từ S – M – L – XL. Áo mặc để đi tập yoga, gym, các môn thể thao khác và đi chơi cũng đều đẹp lắm luôn.', 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (15, N'Áo ba lỗ Jordan', N'https://cf.shopee.vn/file/fe53b1892fba0055c193fa25ef95cd47', 170.0000, N'JORDAN', N'Áo thun balo jordan Kiểu áo thể thao thích hợp cho mấy bạn chơi bóng rổ Size M L XLCác bạn đtawj hàng nhớ liên hệ shop để check màu và size nhé', 3)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID]) VALUES (16, N'Áo NBA Jersey Chicago Bulls Red - Jordan', N'https://giaybongro.vn/upload/images/998240400/63/3265_1589913835.jpg', 200.0000, N'JORDAN', N'Quần Áo Jersey NBA là loại quần áo thi đấu chính thức của các cầu thủ tại NBA, Chất liệu vải cao cấp, logo đội bóng, tên cầu thủ, số áo được thêu rất chắc chắn có độ hoàn thiện rất cao, không bị bong tróc như chất liệu in ấn thông thường.', 3)
SET IDENTITY_INSERT [dbo].[product] OFF
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Orders] FOREIGN KEY([orderId])
REFERENCES [dbo].[Orders] ([id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Orders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_product] FOREIGN KEY([productId])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_product]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Account] FOREIGN KEY([uID])
REFERENCES [dbo].[Account] ([uID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Account]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_Category] FOREIGN KEY([cateID])
REFERENCES [dbo].[Category] ([cid])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_Category]
GO
