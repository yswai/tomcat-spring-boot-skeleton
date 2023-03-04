IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[YourTable]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[YourTable] (
	id int IDENTITY(0,1) NOT NULL,
	Column1 varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
);
END