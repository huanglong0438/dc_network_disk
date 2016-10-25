create table if not exists t_user(
	uid int unsigned primary key auto_increment comment '用户Id号，自增主键',
	username varchar(20) not null unique comment '用户名',
	password varchar(256) comment '用户密码(md5)',
	email varchar(320) unique comment 'email地址',
	phone varchar(11) unique comment '手机号',
	avatar char(10) comment '用户头像序号',
	whatsup varchar(200) comment '用户个性签名',
	
	create_date timestamp not null default current_timestamp,
	modified_date timestamp not null default current_timestamp on update current_timestamp
);

create table if not exists t_file_list(
	fid int unsigned primary key auto_increment comment '文件ID号，自增主键',
	filename varchar(256)  not null comment '文件名',
	filetype varchar(50) comment '文件类型',
	isdir char(1) comment '是否目录，0为文件，1为目录',
	filepath varchar(256) comment '文件路径，相对路径',
	filesize bigint comment '文件大小，单位字节',
	ownerName varchar(20) comment '文件所有者的用户名',
	
	create_date timestamp(6) not null default current_timestamp(6) comment '文件创建日期',
	modified_date timestamp(6) not null default current_timestamp(6) on update current_timestamp(6) comment '文件修改日期',
	
	foreign key(ownerName) references t_user(username)
);