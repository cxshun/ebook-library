create table `user` (
  `id` bigint primary key comment '主键ID',
  `name` varchar(100) not null comment '用户名称',
  `password` varchar(512) not null comment '用户密码',
  `email` varchar(64) not null comment '用户邮箱',
  `is_active` tinyint not null default 1 comment '是否激活，1-是，0-否',
  `create_time` datetime default '2019-01-01 11:11:11' comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '更新时间',
  `is_deleted` tinyint default 0 comment '是否删除 1-是，0-否',
  index idx_name_psw(`name`, password)
) AUTO_INCREMENT = 1 default character_set=utf8mb4 comment '用户信息表';

create table `privilege` (
  `id` bigint primary key AUTO_INCREMENT comment '主键ID',
  `name` varchar(128) not null comment '权限名称',
  `desc` varchar(128) not null comment '权限描述',
  `type` tinyint default 1 not null comment '权限类型，1-页面，2-操作点',
  `create_time` datetime not null default '2019-01-01 11:11:11' comment '创建时间',
  `update_time` datetime not null default current_timestamp on update current_timestamp comment '更新时间',
  `is_deleted` tinyint default 0 comment '是否删除 1-是，0-否'
) ENGINE=INNODB AUTO_INCREMENT = 1 default charset=utf8mb4 comment '权限信息表';

create table `role` (
  `id` bigint primary key  comment '主键ID',
  `name` varchar(128) not null comment '角色名称',
  `desc` varchar(128) not null comment '角色描述',
  `create_time` datetime default '2019-01-01 11:11:11' comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '更新时间',
  `is_deleted` tinyint default 0 comment '是否删除 1-是，0-否'
) ENGINE=INNODB AUTO_INCREMENT = 1 default charset=utf8mb4 comment '角色信息表';

create table `role_privilege` (
  `id` bigint primary key  comment '主键ID',
  `role_id` bigint not null comment '角色ID',
  `privilege_id` bigint not null comment '权限ID',
  `create_time` datetime default '2019-01-01 11:11:11' comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '更新时间',
  `is_deleted` tinyint default 0 comment '是否删除 1-是，0-否',
  index idx_role_privilege(role_id, privilege_id)
) ENGINE=INNODB AUTO_INCREMENT = 1 default charset=utf8mb4 comment '角色信息表';

create table `user_role` (
  `id` bigint primary key  comment '主键ID',
  `user_id` bigint not null comment '用户ID',
  `role_id` bigint not null comment '角色ID',
  `create_time` datetime default '2019-01-01 11:11:11' comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '更新时间',
  `is_deleted` tinyint default 0 comment '是否删除 1-是，0-否',
  index idx_role_privilege(user_id, role_id)
) ENGINE=INNODB AUTO_INCREMENT = 1 default charset=utf8mb4 comment '用户角色表';
