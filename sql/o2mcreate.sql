DROP TABLE IF EXISTS flight_right;
CREATE TABLE flight_right(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    product_name VARCHAR(60)    COMMENT '产品名称' ,
    ·desc· VARCHAR(60)    COMMENT '产品描述信息' ,
    status VARCHAR(60)    COMMENT '产品状态' ,
    max_count INT    COMMENT '最大销售数量' ,
    code_amount INT    COMMENT '权益次数' ,
    sale_price DECIMAL(10,2)    COMMENT '销售价格' ,
    start_date DATETIME    COMMENT '权益有效开始日期' ,
    end_date DATETIME    COMMENT '权益截止兑换时间' ,
    sale_start_date DATETIME    COMMENT '销售开始时间' ,
    sale_end_date DATETIME    COMMENT '销售结束时间' ,
    stock INT    COMMENT '库存' ,
    source_limit VARCHAR(255)    COMMENT '产品来源限制（航司）' ,
    order_link VARCHAR(255)    COMMENT '预定的入口' ,
    picture VARCHAR(255)    COMMENT '宣传图' ,
    departure_list VARCHAR(900)    COMMENT '出发地列表' ,
    arrive_list VARCHAR(900)    COMMENT '目的地列表' ,
    PRIMARY KEY (id)
)  COMMENT = '机票权益表';

DROP TABLE IF EXISTS hotel_right;
CREATE TABLE hotel_right(
    TENANT_ID VARCHAR(32)    COMMENT '租户号' ,
    REVISION VARCHAR(32)    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
)  COMMENT = '酒店权益表';

DROP TABLE IF EXISTS package_rights;
CREATE TABLE package_rights(
    TENANT_ID VARCHAR(32)    COMMENT '租户号' ,
    REVISION VARCHAR(32)    COMMENT '乐观锁' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' 
)  COMMENT = '打包权益组合';

DROP TABLE IF EXISTS flight_right_code;
CREATE TABLE flight_right_code(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    check_code VARCHAR(32) NOT NULL   COMMENT '校验码' ,
    public_code VARCHAR(32) NOT NULL   COMMENT '给客户的码' ,
    real_code VARCHAR(32) NOT NULL   COMMENT '后台真实码' ,
    create_time DATETIME    COMMENT '创建时间' ,
    create_by VARCHAR(60)    COMMENT '创建人' ,
    status VARCHAR(60)    COMMENT 'code状态' ,
    product_id INT    COMMENT '对应权益产品id' ,
    start_date DATETIME    COMMENT 'code有效期开始' ,
    end_date DATETIME    COMMENT 'code有效期结束' ,
    remark VARCHAR(900)    COMMENT '' ,
    bind_time DATETIME    COMMENT '绑定时间' ,
    bind_user_name VARCHAR(60)    COMMENT '绑定用户名' ,
    bind_user_id VARCHAR(60)    COMMENT '绑定用户id' ,
    bind_user_phone VARCHAR(60)    COMMENT '绑定用户手机号' ,
    channel VARCHAR(60)    COMMENT '所属渠道（分支）' ,
    PRIMARY KEY (id)
)  COMMENT = '机票权益code';

DROP TABLE IF EXISTS flight_order;
CREATE TABLE flight_order(
    id VARCHAR(60)    COMMENT '' ,
    user_id VARCHAR(60)    COMMENT '' ,
    product_id VARCHAR(60)    COMMENT '' ,
    order_price VARCHAR(60)    COMMENT '' ,
    order_time VARCHAR(60)    COMMENT '' ,
    pay_price VARCHAR(60)    COMMENT '' ,
    pay_type VARCHAR(60)    COMMENT '' ,
    product_amount VARCHAR(60)    COMMENT '' 
)  COMMENT = '机票产品订单表';

DROP TABLE IF EXISTS gen_table;
CREATE TABLE gen_table(
    table_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '编号' ,
    table_name VARCHAR(200)    COMMENT '表名称' ,
    table_comment VARCHAR(500)    COMMENT '表描述' ,
    sub_table_name VARCHAR(64)    COMMENT '关联子表的表名' ,
    sub_table_fk_name VARCHAR(64)    COMMENT '子表关联的外键名' ,
    class_name VARCHAR(100)    COMMENT '实体类名称' ,
    tpl_category VARCHAR(200)   DEFAULT 'crud' COMMENT '使用的模板（crud单表操作;tree树表操作 sub主子表操作）' ,
    package_name VARCHAR(100)    COMMENT '生成包路径' ,
    module_name VARCHAR(30)    COMMENT '生成模块名' ,
    business_name VARCHAR(30)    COMMENT '生成业务名' ,
    function_name VARCHAR(50)    COMMENT '生成功能名' ,
    function_author VARCHAR(50)    COMMENT '生成功能作者' ,
    gen_type CHAR(1)   DEFAULT '0' COMMENT '生成代码方式（0zip压缩包;1自定义路径）' ,
    gen_path VARCHAR(200)   DEFAULT '/' COMMENT '生成路径（不填默认项目路径）' ,
    options VARCHAR(1000)    COMMENT '其它生成选项' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (table_id)
)  COMMENT = '代码生成业务表';


CREATE UNIQUE INDEX idx_gen_table_table_id ON gen_table(table_id);

DROP TABLE IF EXISTS gen_table_column;
CREATE TABLE gen_table_column(
    column_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '编号' ,
    table_id VARCHAR(64)    COMMENT '归属表编号' ,
    column_name VARCHAR(200)    COMMENT '列名称' ,
    column_comment VARCHAR(500)    COMMENT '列描述' ,
    column_type VARCHAR(100)    COMMENT '列类型' ,
    java_type VARCHAR(500)    COMMENT 'JAVA类型' ,
    java_field VARCHAR(200)    COMMENT 'JAVA字段名' ,
    is_pk CHAR(1)    COMMENT '是否主键（1是）' ,
    is_increment CHAR(1)    COMMENT '是否自增（1是）' ,
    is_required CHAR(1)    COMMENT '是否必填（1是）' ,
    is_insert CHAR(1)    COMMENT '是否为插入字段（1是）' ,
    is_edit CHAR(1)    COMMENT '是否编辑字段（1是）' ,
    is_list CHAR(1)    COMMENT '是否列表字段（1是）' ,
    is_query CHAR(1)    COMMENT '是否查询字段（1是）' ,
    query_type VARCHAR(200)   DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）' ,
    html_type VARCHAR(200)    COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）' ,
    dict_type VARCHAR(200)    COMMENT '字典类型' ,
    sort INT(11)    COMMENT '排序' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (column_id)
)  COMMENT = '代码生成业务表字段';


CREATE UNIQUE INDEX idex_gen_table_column_column_id ON gen_table_column(column_id);

DROP TABLE IF EXISTS qrtz_blob_triggers;
CREATE TABLE qrtz_blob_triggers(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    trigger_name VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_name的外键' ,
    trigger_group VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_group的外键' ,
    blob_data BLOB    COMMENT '存放持久化Trigger对象' ,
    PRIMARY KEY (sched_name,trigger_name,trigger_group)
)  COMMENT = 'Blob类型的触发器表';


CREATE UNIQUE INDEX idx_qrtz_blob_triggers_sched_name_trigger_name_trigger_group ON qrtz_blob_triggers(sched_name,trigger_name,trigger_group);

DROP TABLE IF EXISTS qrtz_calendars;
CREATE TABLE qrtz_calendars(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    calendar_name VARCHAR(200) NOT NULL   COMMENT '日历名称' ,
    calendar BLOB NOT NULL   COMMENT '存放持久化calendar对象' ,
    PRIMARY KEY (sched_name,calendar_name)
)  COMMENT = '日历信息表';


CREATE UNIQUE INDEX idx_qrtz_calendars_sched_name_calendar_name ON qrtz_calendars(sched_name,calendar_name);

DROP TABLE IF EXISTS qrtz_cron_triggers;
CREATE TABLE qrtz_cron_triggers(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    trigger_name VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_name的外键' ,
    trigger_group VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_group的外键' ,
    cron_expression VARCHAR(200) NOT NULL   COMMENT 'cron表达式' ,
    time_zone_id VARCHAR(80)    COMMENT '时区' ,
    PRIMARY KEY (sched_name,trigger_name,trigger_group)
)  COMMENT = 'Cron类型的触发器表';


CREATE UNIQUE INDEX idx_qrtz_cron_triggers_sched_name_trigger_name_trigger_group ON qrtz_cron_triggers(sched_name,trigger_name,trigger_group);

DROP TABLE IF EXISTS qrtz_fired_triggers;
CREATE TABLE qrtz_fired_triggers(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    entry_id VARCHAR(95) NOT NULL   COMMENT '调度器实例id' ,
    trigger_name VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_name的外键' ,
    trigger_group VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_group的外键' ,
    instance_name VARCHAR(200) NOT NULL   COMMENT '调度器实例名' ,
    fired_time BIGINT(20) NOT NULL   COMMENT '触发的时间' ,
    sched_time BIGINT(20) NOT NULL   COMMENT '定时器制定的时间' ,
    priority INT(11) NOT NULL   COMMENT '优先级' ,
    state VARCHAR(16) NOT NULL   COMMENT '状态' ,
    job_name VARCHAR(200)    COMMENT '任务名称' ,
    job_group VARCHAR(200)    COMMENT '任务组名' ,
    is_nonconcurrent VARCHAR(1)    COMMENT '是否并发' ,
    requests_recovery VARCHAR(1)    COMMENT '是否接受恢复执行' ,
    PRIMARY KEY (sched_name,entry_id)
)  COMMENT = '已触发的触发器表';


CREATE UNIQUE INDEX idx_qrtz_fired_triggers_sched_name_entry_id ON qrtz_fired_triggers(sched_name,entry_id);

DROP TABLE IF EXISTS qrtz_job_details;
CREATE TABLE qrtz_job_details(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    job_name VARCHAR(200) NOT NULL   COMMENT '任务名称' ,
    job_group VARCHAR(200) NOT NULL   COMMENT '任务组名' ,
    description VARCHAR(250)    COMMENT '相关介绍' ,
    job_class_name VARCHAR(250) NOT NULL   COMMENT '执行任务类名称' ,
    is_durable VARCHAR(1) NOT NULL   COMMENT '是否持久化' ,
    is_nonconcurrent VARCHAR(1) NOT NULL   COMMENT '是否并发' ,
    is_update_data VARCHAR(1) NOT NULL   COMMENT '是否更新数据' ,
    requests_recovery VARCHAR(1) NOT NULL   COMMENT '是否接受恢复执行' ,
    job_data BLOB    COMMENT '存放持久化job对象' ,
    PRIMARY KEY (sched_name,job_name,job_group)
)  COMMENT = '任务详细信息表';


CREATE UNIQUE INDEX idx_qrtz_job_details_sched_name_job_name_job_group ON qrtz_job_details(sched_name,job_name,job_group);

DROP TABLE IF EXISTS qrtz_locks;
CREATE TABLE qrtz_locks(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    lock_name VARCHAR(40) NOT NULL   COMMENT '悲观锁名称' ,
    PRIMARY KEY (sched_name,lock_name)
)  COMMENT = '存储的悲观锁信息表';


CREATE UNIQUE INDEX idx_qrtz_locks_sched_name_lock_name ON qrtz_locks(sched_name,lock_name);

DROP TABLE IF EXISTS qrtz_paused_trigger_grps;
CREATE TABLE qrtz_paused_trigger_grps(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    trigger_group VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_group的外键' ,
    PRIMARY KEY (sched_name,trigger_group)
)  COMMENT = '暂停的触发器表';


CREATE UNIQUE INDEX idx_qrtz_paused_trigger_grps_sched_name_trigger_group ON qrtz_paused_trigger_grps(sched_name,trigger_group);

DROP TABLE IF EXISTS qrtz_scheduler_state;
CREATE TABLE qrtz_scheduler_state(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    instance_name VARCHAR(200) NOT NULL   COMMENT '实例名称' ,
    last_checkin_time BIGINT(20) NOT NULL   COMMENT '上次检查时间' ,
    checkin_interval BIGINT(20) NOT NULL   COMMENT '检查间隔时间' ,
    PRIMARY KEY (sched_name,instance_name)
)  COMMENT = '调度器状态表';


CREATE UNIQUE INDEX idx_qrtz_scheduler_state_sched_name_instance_name ON qrtz_scheduler_state(sched_name,instance_name);

DROP TABLE IF EXISTS qrtz_simple_triggers;
CREATE TABLE qrtz_simple_triggers(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    trigger_name VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_name的外键' ,
    trigger_group VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_group的外键' ,
    repeat_count BIGINT(20) NOT NULL   COMMENT '重复的次数统计' ,
    repeat_interval BIGINT(20) NOT NULL   COMMENT '重复的间隔时间' ,
    times_triggered BIGINT(20) NOT NULL   COMMENT '已经触发的次数' ,
    PRIMARY KEY (sched_name,trigger_name,trigger_group)
)  COMMENT = '简单触发器的信息表';


CREATE UNIQUE INDEX idx_qrtz_simple_triggers_sched_name_trigger_name_trigger_group ON qrtz_simple_triggers(sched_name,trigger_name,trigger_group);

DROP TABLE IF EXISTS qrtz_simprop_triggers;
CREATE TABLE qrtz_simprop_triggers(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    trigger_name VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_name的外键' ,
    trigger_group VARCHAR(200) NOT NULL   COMMENT 'qrtz_triggers表trigger_group的外键' ,
    str_prop_1 VARCHAR(512)    COMMENT 'String类型的trigger的第一个参数' ,
    str_prop_2 VARCHAR(512)    COMMENT 'String类型的trigger的第二个参数' ,
    str_prop_3 VARCHAR(512)    COMMENT 'String类型的trigger的第三个参数' ,
    int_prop_1 INT(11)    COMMENT 'int类型的trigger的第一个参数' ,
    int_prop_2 INT(11)    COMMENT 'int类型的trigger的第二个参数' ,
    long_prop_1 BIGINT(20)    COMMENT 'long类型的trigger的第一个参数' ,
    long_prop_2 BIGINT(20)    COMMENT 'long类型的trigger的第二个参数' ,
    dec_prop_1 DECIMAL(13,4)    COMMENT 'decimal类型的trigger的第一个参数' ,
    dec_prop_2 DECIMAL(13,4)    COMMENT 'decimal类型的trigger的第二个参数' ,
    bool_prop_1 VARCHAR(1)    COMMENT 'Boolean类型的trigger的第一个参数' ,
    bool_prop_2 VARCHAR(1)    COMMENT 'Boolean类型的trigger的第二个参数' ,
    PRIMARY KEY (sched_name,trigger_name,trigger_group)
)  COMMENT = '同步机制的行锁表';


CREATE UNIQUE INDEX idx_qrtz_simprop_triggers_sched_name_trigger_name_trigger_group ON qrtz_simprop_triggers(sched_name,trigger_name,trigger_group);

DROP TABLE IF EXISTS qrtz_triggers;
CREATE TABLE qrtz_triggers(
    sched_name VARCHAR(120) NOT NULL   COMMENT '调度名称' ,
    trigger_name VARCHAR(200) NOT NULL   COMMENT '触发器的名字' ,
    trigger_group VARCHAR(200) NOT NULL   COMMENT '触发器所属组的名字' ,
    job_name VARCHAR(200) NOT NULL   COMMENT 'qrtz_job_details表job_name的外键' ,
    job_group VARCHAR(200) NOT NULL   COMMENT 'qrtz_job_details表job_group的外键' ,
    description VARCHAR(250)    COMMENT '相关介绍' ,
    next_fire_time BIGINT(20)    COMMENT '上一次触发时间（毫秒）' ,
    prev_fire_time BIGINT(20)    COMMENT '下一次触发时间（默认为-1表示不触发）' ,
    priority INT(11)    COMMENT '优先级' ,
    trigger_state VARCHAR(16) NOT NULL   COMMENT '触发器状态' ,
    trigger_type VARCHAR(8) NOT NULL   COMMENT '触发器的类型' ,
    start_time BIGINT(20) NOT NULL   COMMENT '开始时间' ,
    end_time BIGINT(20)    COMMENT '结束时间' ,
    calendar_name VARCHAR(200)    COMMENT '日程表名称' ,
    misfire_instr SMALLINT(6)    COMMENT '补偿执行的策略' ,
    job_data BLOB    COMMENT '存放持久化job对象' ,
    PRIMARY KEY (sched_name,trigger_name,trigger_group)
)  COMMENT = '触发器详细信息表';


CREATE UNIQUE INDEX idx_qrtz_triggers_sched_name_trigger_name_trigger_group ON qrtz_triggers(sched_name,trigger_name,trigger_group);
CREATE INDEX sched_name ON qrtz_triggers(sched_name,job_name,job_group);

DROP TABLE IF EXISTS sys_config;
CREATE TABLE sys_config(
    config_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '参数主键' ,
    config_name VARCHAR(100)    COMMENT '参数名称' ,
    config_key VARCHAR(100)    COMMENT '参数键名' ,
    config_value VARCHAR(500)    COMMENT '参数键值' ,
    config_type CHAR(1)   DEFAULT 'N' COMMENT '系统内置（Y是;N否）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (config_id)
)  COMMENT = '参数配置表';


CREATE UNIQUE INDEX idx_sys_config_config_id ON sys_config(config_id);

DROP TABLE IF EXISTS sys_dept;
CREATE TABLE sys_dept(
    dept_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '部门id' ,
    parent_id BIGINT(20)   DEFAULT 0 COMMENT '父部门id' ,
    ancestors VARCHAR(50)    COMMENT '祖级列表' ,
    dept_name VARCHAR(30)    COMMENT '部门名称' ,
    order_num INT(11)   DEFAULT 0 COMMENT '显示顺序' ,
    leader VARCHAR(20)    COMMENT '负责人' ,
    phone VARCHAR(11)    COMMENT '联系电话' ,
    email VARCHAR(50)    COMMENT '邮箱' ,
    status CHAR(1)   DEFAULT '0' COMMENT '部门状态（0正常;1停用）' ,
    del_flag CHAR(1)   DEFAULT '0' COMMENT '删除标志（0代表存在;2代表删除）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (dept_id)
)  COMMENT = '部门表';


CREATE UNIQUE INDEX idx_sys_dept_dept_id ON sys_dept(dept_id);

DROP TABLE IF EXISTS sys_dict_data;
CREATE TABLE sys_dict_data(
    dict_code BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '字典编码' ,
    dict_sort INT(11)   DEFAULT 0 COMMENT '字典排序' ,
    dict_label VARCHAR(100)    COMMENT '字典标签' ,
    dict_value VARCHAR(100)    COMMENT '字典键值' ,
    dict_type VARCHAR(100)    COMMENT '字典类型' ,
    css_class VARCHAR(100)    COMMENT '样式属性（其他样式扩展）' ,
    list_class VARCHAR(100)    COMMENT '表格回显样式' ,
    is_default CHAR(1)   DEFAULT 'N' COMMENT '是否默认（Y是;N否）' ,
    status CHAR(1)   DEFAULT '0' COMMENT '状态（0正常;1停用）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (dict_code)
)  COMMENT = '字典数据表';


CREATE UNIQUE INDEX idx_sys_dict_data_dict_code ON sys_dict_data(dict_code);

DROP TABLE IF EXISTS sys_dict_type;
CREATE TABLE sys_dict_type(
    dict_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '字典主键' ,
    dict_name VARCHAR(100)    COMMENT '字典名称' ,
    dict_type VARCHAR(100)    COMMENT '字典类型' ,
    status CHAR(1)   DEFAULT '0' COMMENT '状态（0正常;1停用）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (dict_id)
)  COMMENT = '字典类型表';


CREATE UNIQUE INDEX idx_sys_dict_type_dict_type ON sys_dict_type(dict_type);
CREATE UNIQUE INDEX idx_sys_dict_type_dict_id ON sys_dict_type(dict_id);

DROP TABLE IF EXISTS sys_job;
CREATE TABLE sys_job(
    job_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '任务ID' ,
    job_name VARCHAR(64) NOT NULL   COMMENT '任务名称' ,
    job_group VARCHAR(64) NOT NULL  DEFAULT 'DEFAULT' COMMENT '任务组名' ,
    invoke_target VARCHAR(500) NOT NULL   COMMENT '调用目标字符串' ,
    cron_expression VARCHAR(255)    COMMENT 'cron执行表达式' ,
    misfire_policy VARCHAR(20)   DEFAULT '3' COMMENT '计划执行错误策略（1立即执行;2执行一次 3放弃执行）' ,
    concurrent CHAR(1)   DEFAULT '1' COMMENT '是否并发执行（0允许;1禁止）' ,
    status CHAR(1)   DEFAULT '0' COMMENT '状态（0正常;1暂停）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注信息' ,
    PRIMARY KEY (job_id,job_name,job_group)
)  COMMENT = '定时任务调度表';


CREATE UNIQUE INDEX idx_sys_job_job_id_job_name_job_group ON sys_job(job_id,job_name,job_group);

DROP TABLE IF EXISTS sys_job_log;
CREATE TABLE sys_job_log(
    job_log_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '任务日志ID' ,
    job_name VARCHAR(64) NOT NULL   COMMENT '任务名称' ,
    job_group VARCHAR(64) NOT NULL   COMMENT '任务组名' ,
    invoke_target VARCHAR(500) NOT NULL   COMMENT '调用目标字符串' ,
    job_message VARCHAR(500)    COMMENT '日志信息' ,
    status CHAR(1)   DEFAULT '0' COMMENT '执行状态（0正常;1失败）' ,
    exception_info VARCHAR(2000)    COMMENT '异常信息' ,
    create_time DATETIME    COMMENT '创建时间' ,
    PRIMARY KEY (job_log_id)
)  COMMENT = '定时任务调度日志表';


CREATE UNIQUE INDEX idx_sys_job_log_job_log_id ON sys_job_log(job_log_id);

DROP TABLE IF EXISTS sys_logininfor;
CREATE TABLE sys_logininfor(
    info_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '访问ID' ,
    login_name VARCHAR(50)    COMMENT '登录账号' ,
    ipaddr VARCHAR(128)    COMMENT '登录IP地址' ,
    login_location VARCHAR(255)    COMMENT '登录地点' ,
    browser VARCHAR(50)    COMMENT '浏览器类型' ,
    os VARCHAR(50)    COMMENT '操作系统' ,
    status CHAR(1)   DEFAULT '0' COMMENT '登录状态（0成功;1失败）' ,
    msg VARCHAR(255)    COMMENT '提示消息' ,
    login_time DATETIME    COMMENT '访问时间' ,
    PRIMARY KEY (info_id)
)  COMMENT = '系统访问记录';


CREATE UNIQUE INDEX idx_sys_logininfor_info_id ON sys_logininfor(info_id);

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu(
    menu_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '菜单ID' ,
    menu_name VARCHAR(50) NOT NULL   COMMENT '菜单名称' ,
    parent_id BIGINT(20)   DEFAULT 0 COMMENT '父菜单ID' ,
    order_num INT(11)   DEFAULT 0 COMMENT '显示顺序' ,
    url VARCHAR(200)   DEFAULT '#' COMMENT '请求地址' ,
    target VARCHAR(20)    COMMENT '打开方式（menuItem页签;menuBlank新窗口）' ,
    menu_type CHAR(1)    COMMENT '菜单类型（M目录;C菜单 F按钮）' ,
    visible CHAR(1)   DEFAULT '0' COMMENT '菜单状态（0显示;1隐藏）' ,
    is_refresh CHAR(1)   DEFAULT '1' COMMENT '是否刷新（0刷新;1不刷新）' ,
    perms VARCHAR(100)    COMMENT '权限标识' ,
    icon VARCHAR(100)   DEFAULT '#' COMMENT '菜单图标' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (menu_id)
)  COMMENT = '菜单权限表';


CREATE UNIQUE INDEX idx_sys_menu_menu_id ON sys_menu(menu_id);

DROP TABLE IF EXISTS sys_notice;
CREATE TABLE sys_notice(
    notice_id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '公告ID' ,
    notice_title VARCHAR(50) NOT NULL   COMMENT '公告标题' ,
    notice_type CHAR(1) NOT NULL   COMMENT '公告类型（1通知;2公告）' ,
    notice_content VARCHAR(2000)    COMMENT '公告内容' ,
    status CHAR(1)   DEFAULT '0' COMMENT '公告状态（0正常;1关闭）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(255)    COMMENT '备注' ,
    PRIMARY KEY (notice_id)
)  COMMENT = '通知公告表';


CREATE UNIQUE INDEX idx_sys_notice_notice_id ON sys_notice(notice_id);

DROP TABLE IF EXISTS sys_oper_log;
CREATE TABLE sys_oper_log(
    oper_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '日志主键' ,
    title VARCHAR(50)    COMMENT '模块标题' ,
    business_type INT(11)   DEFAULT 0 COMMENT '业务类型（0其它;1新增 2修改 3删除）' ,
    method VARCHAR(100)    COMMENT '方法名称' ,
    request_method VARCHAR(10)    COMMENT '请求方式' ,
    operator_type INT(11)   DEFAULT 0 COMMENT '操作类别（0其它;1后台用户 2手机端用户）' ,
    oper_name VARCHAR(50)    COMMENT '操作人员' ,
    dept_name VARCHAR(50)    COMMENT '部门名称' ,
    oper_url VARCHAR(255)    COMMENT '请求URL' ,
    oper_ip VARCHAR(128)    COMMENT '主机地址' ,
    oper_location VARCHAR(255)    COMMENT '操作地点' ,
    oper_param VARCHAR(2000)    COMMENT '请求参数' ,
    json_result VARCHAR(2000)    COMMENT '返回参数' ,
    status INT(11)   DEFAULT 0 COMMENT '操作状态（0正常;1异常）' ,
    error_msg VARCHAR(2000)    COMMENT '错误消息' ,
    oper_time DATETIME    COMMENT '操作时间' ,
    PRIMARY KEY (oper_id)
)  COMMENT = '操作日志记录';


CREATE UNIQUE INDEX idx_sys_oper_log_oper_id ON sys_oper_log(oper_id);

DROP TABLE IF EXISTS sys_post;
CREATE TABLE sys_post(
    post_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '岗位ID' ,
    post_code VARCHAR(64) NOT NULL   COMMENT '岗位编码' ,
    post_name VARCHAR(50) NOT NULL   COMMENT '岗位名称' ,
    post_sort INT(11) NOT NULL   COMMENT '显示顺序' ,
    status CHAR(1) NOT NULL   COMMENT '状态（0正常;1停用）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (post_id)
)  COMMENT = '岗位信息表';


CREATE UNIQUE INDEX idx_sys_post_post_id ON sys_post(post_id);

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
    role_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '角色ID' ,
    role_name VARCHAR(30) NOT NULL   COMMENT '角色名称' ,
    role_key VARCHAR(100) NOT NULL   COMMENT '角色权限字符串' ,
    role_sort INT(11) NOT NULL   COMMENT '显示顺序' ,
    data_scope CHAR(1)   DEFAULT '1' COMMENT '数据范围（1：全部数据权限;2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）' ,
    status CHAR(1) NOT NULL   COMMENT '角色状态（0正常;1停用）' ,
    del_flag CHAR(1)   DEFAULT '0' COMMENT '删除标志（0代表存在;2代表删除）' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (role_id)
)  COMMENT = '角色信息表';


CREATE UNIQUE INDEX idx_sys_role_role_id ON sys_role(role_id);
CREATE INDEX idx_sys_role_role_id_index ON sys_role(role_id);

DROP TABLE IF EXISTS sys_role_dept;
CREATE TABLE sys_role_dept(
    role_id BIGINT(20) NOT NULL   COMMENT '角色ID' ,
    dept_id BIGINT(20) NOT NULL   COMMENT '部门ID' ,
    PRIMARY KEY (role_id,dept_id)
)  COMMENT = '角色和部门关联表';


CREATE UNIQUE INDEX idx_sys_role_dept_role_id_dept_id  ON sys_role_dept(role_id,dept_id);

DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu(
    role_id BIGINT(20) NOT NULL   COMMENT '角色ID' ,
    menu_id BIGINT(20) NOT NULL   COMMENT '菜单ID' ,
    PRIMARY KEY (role_id,menu_id)
)  COMMENT = '角色和菜单关联表';


CREATE UNIQUE INDEX idx_sys_role_menu_role_id_menu_id ON sys_role_menu(role_id,menu_id);

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
    user_id BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '用户ID' ,
    dept_id BIGINT(20)    COMMENT '部门ID' ,
    login_name VARCHAR(30) NOT NULL   COMMENT '登录账号' ,
    user_name VARCHAR(30)    COMMENT '用户昵称' ,
    user_type VARCHAR(2)   DEFAULT '00' COMMENT '用户类型（00系统用户;01注册用户）' ,
    email VARCHAR(50)    COMMENT '用户邮箱' ,
    phonenumber VARCHAR(11)    COMMENT '手机号码' ,
    sex CHAR(1)   DEFAULT '0' COMMENT '用户性别（0男;1女 2未知）' ,
    avatar VARCHAR(100)    COMMENT '头像路径' ,
    password VARCHAR(50)    COMMENT '密码' ,
    salt VARCHAR(20)    COMMENT '盐加密' ,
    status CHAR(1)   DEFAULT '0' COMMENT '帐号状态（0正常;1停用）' ,
    del_flag CHAR(1)   DEFAULT '0' COMMENT '删除标志（0代表存在;2代表删除）' ,
    login_ip VARCHAR(128)    COMMENT '最后登录IP' ,
    login_date DATETIME    COMMENT '最后登录时间' ,
    pwd_update_date DATETIME    COMMENT '密码最后更新时间' ,
    create_by VARCHAR(64)    COMMENT '创建者' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(64)    COMMENT '更新者' ,
    update_time DATETIME    COMMENT '更新时间' ,
    remark VARCHAR(500)    COMMENT '备注' ,
    PRIMARY KEY (user_id)
)  COMMENT = '用户信息表';


CREATE UNIQUE INDEX idx_sys_user_user_id ON sys_user(user_id);

DROP TABLE IF EXISTS sys_user_online;
CREATE TABLE sys_user_online(
    sessionId VARCHAR(50) NOT NULL   COMMENT '用户会话id' ,
    login_name VARCHAR(50)    COMMENT '登录账号' ,
    dept_name VARCHAR(50)    COMMENT '部门名称' ,
    ipaddr VARCHAR(128)    COMMENT '登录IP地址' ,
    login_location VARCHAR(255)    COMMENT '登录地点' ,
    browser VARCHAR(50)    COMMENT '浏览器类型' ,
    os VARCHAR(50)    COMMENT '操作系统' ,
    status VARCHAR(10)    COMMENT '在线状态on_line在线off_line离线' ,
    start_timestamp DATETIME    COMMENT 'session创建时间' ,
    last_access_time DATETIME    COMMENT 'session最后访问时间' ,
    expire_time INT(11)   DEFAULT 0 COMMENT '超时时间;单位为分钟' ,
    PRIMARY KEY (sessionId)
)  COMMENT = '在线用户记录';


CREATE UNIQUE INDEX idx_sys_user_online_sessionId ON sys_user_online(sessionId);

DROP TABLE IF EXISTS sys_user_post;
CREATE TABLE sys_user_post(
    user_id BIGINT(20) NOT NULL   COMMENT '用户ID' ,
    post_id BIGINT(20) NOT NULL   COMMENT '岗位ID' ,
    PRIMARY KEY (user_id,post_id)
)  COMMENT = '用户与岗位关联表';


CREATE UNIQUE INDEX idx_sys_user_post_user_id_post_id ON sys_user_post(user_id,post_id);

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role(
    user_id BIGINT(20) NOT NULL   COMMENT '用户ID' ,
    role_id BIGINT(20) NOT NULL   COMMENT '角色ID' ,
    PRIMARY KEY (user_id,role_id)
)  COMMENT = '用户和角色关联表';


CREATE UNIQUE INDEX idx_sys_user_role_user_id_role_id ON sys_user_role(user_id,role_id);

DROP TABLE IF EXISTS right_customer;
CREATE TABLE right_customer(
    id VARCHAR(60)    COMMENT '' ,
    customer_name VARCHAR(60)    COMMENT '' ,
    customer_id_type VARCHAR(60)    COMMENT '' ,
    customer_id_code VARCHAR(60)    COMMENT '' ,
    customer_phone VARCHAR(60)    COMMENT '' ,
    customer_openssid VARCHAR(60)    COMMENT '' ,
    customer_status VARCHAR(60)    COMMENT '' ,
    customer_address VARCHAR(60)    COMMENT '' 
)  COMMENT = '权益用户';

