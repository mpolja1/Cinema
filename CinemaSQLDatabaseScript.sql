USE [master]
GO
/****** Object:  Database [JavaProject-Cinema]    Script Date: 22.10.2022. 14:46:55 ******/
CREATE DATABASE [JavaProject-Cinema]

USE [JavaProject-Cinema]
GO
/****** Object:  Table [dbo].[Actor]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actor](
	[IdActor] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](70) NULL,
	[FullName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__Actor__3214EC07EB1573BA] PRIMARY KEY CLUSTERED 
(
	[IdActor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Administrator]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administrator](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](100) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Director]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Director](
	[IdDirector] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](70) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDirector] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Genre]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Genre](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[IdMovie] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](100) NULL,
	[PubDate] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[OriginNaziv] [nvarchar](100) NULL,
	[ImagePath] [nvarchar](150) NULL,
	[Duration] [int] NULL,
	[BeginDate] [nvarchar](50) NULL,
	[GenreID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMovie] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MovieActor]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MovieActor](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MovieId] [int] NULL,
	[ActorId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MovieDirector]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MovieDirector](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MovieId] [int] NULL,
	[DirectorId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[probaDatum]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[probaDatum](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Datum] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserApp]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserApp](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](100) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Administrator] ON 

INSERT [dbo].[Administrator] ([Id], [UserName], [Password]) VALUES (3, N'admin', N'123')
SET IDENTITY_INSERT [dbo].[Administrator] OFF
GO
ALTER TABLE [dbo].[Movie]  WITH CHECK ADD FOREIGN KEY([GenreID])
REFERENCES [dbo].[Genre] ([Id])
GO
ALTER TABLE [dbo].[MovieActor]  WITH CHECK ADD  CONSTRAINT [FK__MovieActo__Actor__60A75C0F] FOREIGN KEY([ActorId])
REFERENCES [dbo].[Actor] ([IdActor])
GO
ALTER TABLE [dbo].[MovieActor] CHECK CONSTRAINT [FK__MovieActo__Actor__60A75C0F]
GO
ALTER TABLE [dbo].[MovieActor]  WITH CHECK ADD FOREIGN KEY([MovieId])
REFERENCES [dbo].[Movie] ([IdMovie])
GO
ALTER TABLE [dbo].[MovieDirector]  WITH CHECK ADD FOREIGN KEY([DirectorId])
REFERENCES [dbo].[Director] ([IdDirector])
GO
ALTER TABLE [dbo].[MovieDirector]  WITH CHECK ADD FOREIGN KEY([MovieId])
REFERENCES [dbo].[Movie] ([IdMovie])
GO
/****** Object:  StoredProcedure [dbo].[AuthAdmin]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[AuthAdmin]
	@Username nvarchar(100),
	@Password nvarchar(50)
as
begin
select* from Administrator
where UserName=@Username and Password=@Password
end
GO
/****** Object:  StoredProcedure [dbo].[AuthUser]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[AuthUser]
	@Username nvarchar(50),
	@Password nvarchar(50)
as
begin 
	select* from UserApp
	where UserName=@Username and Password=@Password
end
GO
/****** Object:  StoredProcedure [dbo].[createActor]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[createActor]
	@FirstName nvarchar(50),
	@LastName nvarchar(60),
	@Fullname nvarchar(70),
	@IdActor int output
as
begin
if not exists(select* from Actor where FullName=@Fullname)
	begin
		insert into Actor(firstName,LastName,FullName)values(@FirstName,@LastName,@Fullname)
		set @IdActor=SCOPE_IDENTITY()
	end
else 
	begin
	set @IdActor = (select IdActor from Actor where FullName=@Fullname)
	return @idActor
	end
end
GO
/****** Object:  StoredProcedure [dbo].[createDirector]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE procedure [dbo].[createDirector]
	@FirstName nvarchar(50),
	@LastName nvarchar(50),
	@IdDirector int output
as
begin
	if not exists(select*from Director where FirstName=@FirstName and LastName=@LastName)
	insert into Director(FirstName,LastName)values(@FirstName,@LastName)
	set @IdDirector=SCOPE_IDENTITY()
end
GO
/****** Object:  StoredProcedure [dbo].[createGenre]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[createGenre]
	@Name nvarchar(30)
as
begin
if not exists (select*from Genre where Name=@Name)
	insert into Genre(Name)values(@Name)
end
GO
/****** Object:  StoredProcedure [dbo].[CreateMovie]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE procedure [dbo].[CreateMovie]
	@Title nvarchar(70),
	@PubDate nvarchar(50),
	@description nvarchar(max),
	@OriginNaziv nvarchar(100),
	@ImagePath nvarchar(100),
	@duration int,
	@beginDate nvarchar(50),
	@GenreName nvarchar(70),
	@IdMovie int output
as
declare @GenreId int
begin
if NOT exists (select * from Genre where Name=@GenreName)
	begin
			insert into Genre(Name)values(@GenreName)
			set @GenreId=SCOPE_IDENTITY()
	end
	begin
		set @GenreId=(select Id from Genre where Name=@GenreName)
		insert into Movie(Title,PubDate,Description,OriginNaziv,ImagePath,Duration,BeginDate,GenreID) values(@Title,@PubDate,@description,@OriginNaziv,@ImagePath,@duration,@beginDate,@GenreId)
		set @IdMovie=SCOPE_IDENTITY()
	end
end
GO
/****** Object:  StoredProcedure [dbo].[createUser]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[createUser]
	@Username nvarchar(50),
	@Password nvarchar(30)
as
begin
insert into UserApp(UserName,Password)values(@Username,@Password)
end
GO
/****** Object:  StoredProcedure [dbo].[deleteActor]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[deleteActor]
	@IdActor int
as
begin
delete from MovieActor where MovieActor.ActorId=@IdActor
delete from Actor
where IdActor=@IdActor
end
GO
/****** Object:  StoredProcedure [dbo].[DeleteAllData]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE procedure [dbo].[DeleteAllData]
  as
  begin
    EXEC sp_MSForEachTable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL' 
	EXEC sp_MSForEachTable 'DELETE FROM ?' 
	EXEC sp_MSForEachTable 'ALTER TABLE ? WITH CHECK CHECK CONSTRAINT ALL' 
  end
GO
/****** Object:  StoredProcedure [dbo].[deleteData]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[deleteData]
as
begin
delete from MovieDirector 
delete from MovieActor
delete from Movie
delete from Actor
delete from Director
delete from Genre
delete from UserApp
end
GO
/****** Object:  StoredProcedure [dbo].[deleteDirector]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[deleteDirector]
	@idDirector int
as
begin
delete from MovieDirector where MovieDirector.DirectorId=@idDirector
delete from Director
where IdDirector=@idDirector
end
GO
/****** Object:  StoredProcedure [dbo].[deleteMovie]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[deleteMovie]
	@IdMovie int
as 
begin
	delete from MovieActor where MovieActor.MovieId=@IdMovie
	delete from Movie
	where IdMovie=@IdMovie
end
GO
/****** Object:  StoredProcedure [dbo].[getActor]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getActor]
	@idActor int
as
begin
	select*from Actor
	where IdActor=@idActor
end
GO
/****** Object:  StoredProcedure [dbo].[getActors]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getActors]
as
begin
	select*from Actor
end
GO
/****** Object:  StoredProcedure [dbo].[getDirector]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getDirector]
	@idDirector int
as
begin
	select* from Director
	where IdDirector=@idDirector
end
GO
/****** Object:  StoredProcedure [dbo].[getDirectors]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getDirectors]
as
begin
	select* from Director
end
GO
/****** Object:  StoredProcedure [dbo].[GetGenres]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[GetGenres]
 as
 begin
  select* from Genre
 end
GO
/****** Object:  StoredProcedure [dbo].[getMovie]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getMovie]
	@IdMovie int
as
begin
	select* from Movie
	where IdMovie=@IdMovie
end
GO
/****** Object:  StoredProcedure [dbo].[getMovieActors]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[getMovieActors]
	@MovieId int
as
select ma.MovieId,a.IdActor,a.FirstName,a.LastName,a.FullName from MovieActor as ma
	inner join Movie as m on m.IdMovie=ma.MovieId
	inner join Actor as a on a.IdActor=ma.ActorId
where ma.MovieId=@MovieId
GO
/****** Object:  StoredProcedure [dbo].[getMovies]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getMovies]
as
begin
	select IdMovie,Title,PubDate,Description,OriginNaziv,ImagePath,Duration,BeginDate,Name as GenreName from Movie
	inner join Genre as g on g.Id=Movie.GenreID
end
GO
/****** Object:  StoredProcedure [dbo].[insertMovieActors]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[insertMovieActors]
	@MovieId int,
	@ActorId int
as
begin
if not exists (select*from MovieActor where MovieId=@MovieId and ActorId=@ActorId)
	insert into MovieActor(MovieId,ActorId)values(@MovieId,@ActorId)
end
GO
/****** Object:  StoredProcedure [dbo].[updateActor]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[updateActor]
	@IdActor int,
	@FirstName nvarchar(50),
	@LastName nvarchar(70)
as
begin
update Actor
	set FirstName=@FirstName,
		LastName=@LastName
	where IdActor=@IdActor
end
GO
/****** Object:  StoredProcedure [dbo].[updateDirector]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[updateDirector]
	@idDirector int,
	@FirstName nvarchar(50),
	@LastName nvarchar(50)
as
begin
	update Director
	set FirstName=@FirstName,
		LastName=@LastName
		where IdDirector=@idDirector
end
GO
/****** Object:  StoredProcedure [dbo].[updateMovie]    Script Date: 22.10.2022. 14:46:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[updateMovie]
	@idMovie int,
	@Title nvarchar(50),
	@pubDate nvarchar(70),
	@description nvarchar(max),
	@originNaziv nvarchar(50),
	@beginDate nvarchar(70),
	@ImagePath nvarchar(200),
	@duration int,
	@GenreId int
as
begin
update Movie set 
	Title=@Title, 
	PubDate=@pubDate,
	Description=@description,
	OriginNaziv=@originNaziv,
	BeginDate=@beginDate,
	ImagePath=@ImagePath,
	Duration=@duration,
	GenreID=@GenreId
where IdMovie=@idMovie
end
GO
USE [master]
GO
ALTER DATABASE [JavaProject-Cinema] SET  READ_WRITE 
GO
