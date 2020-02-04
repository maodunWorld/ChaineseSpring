INSERT INTO `ad_stat` VALUES ('20171103', '0', '4', '22', '1'), ('20171103', '3', '1', '27', '1'), ('20171103', '1', '1', '5', '1'), ('20171103', '6', '2', '17', '2'), ('20171103', '8', '4', '10', '1'), ('20171103', '2', '2', '13', '2')

-- auto-generated definition
create table ad_stat
(
    date        varchar(30)  null,
    province    varchar(100) null,
    city        varchar(100) null,
    adid        int          null,
    click_count int          null
)
    charset = utf8;

