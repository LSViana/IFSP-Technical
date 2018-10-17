
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 10/16/2018 21:03:08
-- Generated from EDMX file: C:\Users\Lucas Viana\source\IFSP-Technical\LP3\Class20\HostMaker\HostMakerDb.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [HostMaker];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[FK_Establishment_Category]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Establishment] DROP CONSTRAINT [FK_Establishment_Category];
GO
IF OBJECT_ID(N'[dbo].[FK_Establishment_City]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Establishment] DROP CONSTRAINT [FK_Establishment_City];
GO
IF OBJECT_ID(N'[dbo].[FK_Room_Establishment]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Room] DROP CONSTRAINT [FK_Room_Establishment];
GO
IF OBJECT_ID(N'[dbo].[FK_Room_RoomKind]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[Room] DROP CONSTRAINT [FK_Room_RoomKind];
GO

-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[Category]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Category];
GO
IF OBJECT_ID(N'[dbo].[City]', 'U') IS NOT NULL
    DROP TABLE [dbo].[City];
GO
IF OBJECT_ID(N'[dbo].[Establishment]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Establishment];
GO
IF OBJECT_ID(N'[dbo].[Room]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Room];
GO
IF OBJECT_ID(N'[dbo].[RoomKind]', 'U') IS NOT NULL
    DROP TABLE [dbo].[RoomKind];
GO
IF OBJECT_ID(N'[dbo].[User]', 'U') IS NOT NULL
    DROP TABLE [dbo].[User];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'Categories'
CREATE TABLE [dbo].[Categories] (
    [Id] int  NOT NULL,
    [Description] varchar(40)  NOT NULL
);
GO

-- Creating table 'Cities'
CREATE TABLE [dbo].[Cities] (
    [Id] int  NOT NULL,
    [Name] varchar(50)  NOT NULL,
    [FederativeUnit] char(2)  NOT NULL
);
GO

-- Creating table 'Establishments'
CREATE TABLE [dbo].[Establishments] (
    [Id] int  NOT NULL,
    [IdCity] int  NOT NULL,
    [IdCategory] int  NOT NULL,
    [Name] varchar(30)  NOT NULL,
    [Address] varchar(50)  NOT NULL,
    [Telephone] varchar(11)  NOT NULL,
    [Site] varchar(40)  NOT NULL
);
GO

-- Creating table 'Rooms'
CREATE TABLE [dbo].[Rooms] (
    [IdEstablishment] int  NOT NULL,
    [Id] int  NOT NULL,
    [IdRoomKind] int  NOT NULL,
    [Available] bit  NOT NULL
);
GO

-- Creating table 'RoomKinds'
CREATE TABLE [dbo].[RoomKinds] (
    [Id] int  NOT NULL,
    [Description] varchar(30)  NOT NULL,
    [DailyCost] float  NOT NULL,
    [Breakfast] bit  NOT NULL
);
GO

-- Creating table 'Users'
CREATE TABLE [dbo].[Users] (
    [Id] int  NOT NULL,
    [Name] varchar(30)  NOT NULL,
    [Login] varchar(20)  NOT NULL,
    [Password] varchar(10)  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [Id] in table 'Categories'
ALTER TABLE [dbo].[Categories]
ADD CONSTRAINT [PK_Categories]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'Cities'
ALTER TABLE [dbo].[Cities]
ADD CONSTRAINT [PK_Cities]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'Establishments'
ALTER TABLE [dbo].[Establishments]
ADD CONSTRAINT [PK_Establishments]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'Rooms'
ALTER TABLE [dbo].[Rooms]
ADD CONSTRAINT [PK_Rooms]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'RoomKinds'
ALTER TABLE [dbo].[RoomKinds]
ADD CONSTRAINT [PK_RoomKinds]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'Users'
ALTER TABLE [dbo].[Users]
ADD CONSTRAINT [PK_Users]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [IdCategory] in table 'Establishments'
ALTER TABLE [dbo].[Establishments]
ADD CONSTRAINT [FK_Establishment_Category]
    FOREIGN KEY ([IdCategory])
    REFERENCES [dbo].[Categories]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Establishment_Category'
CREATE INDEX [IX_FK_Establishment_Category]
ON [dbo].[Establishments]
    ([IdCategory]);
GO

-- Creating foreign key on [IdCity] in table 'Establishments'
ALTER TABLE [dbo].[Establishments]
ADD CONSTRAINT [FK_Establishment_City]
    FOREIGN KEY ([IdCity])
    REFERENCES [dbo].[Cities]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Establishment_City'
CREATE INDEX [IX_FK_Establishment_City]
ON [dbo].[Establishments]
    ([IdCity]);
GO

-- Creating foreign key on [IdEstablishment] in table 'Rooms'
ALTER TABLE [dbo].[Rooms]
ADD CONSTRAINT [FK_Room_Establishment]
    FOREIGN KEY ([IdEstablishment])
    REFERENCES [dbo].[Establishments]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Room_Establishment'
CREATE INDEX [IX_FK_Room_Establishment]
ON [dbo].[Rooms]
    ([IdEstablishment]);
GO

-- Creating foreign key on [IdRoomKind] in table 'Rooms'
ALTER TABLE [dbo].[Rooms]
ADD CONSTRAINT [FK_Room_RoomKind]
    FOREIGN KEY ([IdRoomKind])
    REFERENCES [dbo].[RoomKinds]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_Room_RoomKind'
CREATE INDEX [IX_FK_Room_RoomKind]
ON [dbo].[Rooms]
    ([IdRoomKind]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------