create table members(   -- 사용자 테이블
    id         varchar2(20)  primary key,  -- 아이디(사용자)
    pwd        varchar2(20), -- 비밀번호     
    name       varchar2(40), -- 이름
    email      varchar2(40), -- email
    phone      varchar2(20), -- 휴대폰번호
    indate     date          default sysdate     --가입일
);
insert into MEMBERS(id,pwd,name,email,phone)
values('hong','1111', '홍길동', 'hong@naver.com', '010-1111-2222');
insert into MEMBERS(id,pwd,name,email,phone)
values('hana','1111', '김하나', 'hana@naver.com', '010-1111-3333');
select * from members;


사용자이름, 예약한 영화제목, 예약한 상영관
members, movie, orders

select 
	m.id, 
	m.name, 
	o.cinemas,	
	v.title
from members m
JOIN orders o on m.id = o.id
JOIN movie v on v.movieno = o.movieno;


create table workers(     -- 관리자 테이블     
    id         varchar2(20)  primary key,  -- 아이디(관리자)
    pwd        varchar2(20), -- 비밀번호     
    name       varchar2(40), -- 이름
    email      varchar2(40), -- email
    phone      varchar2(20), -- 휴대폰번호
    indate     date          default sysdate     --가입일
);
insert into workers(id, pwd, name, email, phone)
values('minsun', '1234', '김민선', 'minsun@naver.com', '010-1234-5678');
insert into workers(id, pwd, name, email, phone)
values('joongeun', '1234', '곽중근', 'joongeun@naver.com', '010-1235-5678');
insert into workers(id, pwd, name, email, phone)
values('hyukjeon', '1234', '강혁전', 'hyukjeon@naver.com', '010-1236-5678');
insert into workers(id, pwd, name, email, phone)
values('yoonsoo', '1234', '노윤수', 'yoonsoo@naver.com', '010-1237-5678');
select * from WORKERs;



alter table movie drop primary key cascade;
CREATE TABLE movie (
movieno number NOT NULL primary key, -- 영화번호
title    VARCHAR2(40) NOT NULL, -- 영화제목
director VARCHAR2(40) NOT NULL, -- 감독
actor    VARCHAR2(40) NOT NULL, -- 주연
genre    char(1) NOT NULL, -- 장르
agegrade   VARCHAR2(10)       NOT NULL,      -- 연령별 등급
playtime VARCHAR2(30) NOT NULL, -- 진행시간
opendate VARCHAR2(40) NOT NULL,  -- 개봉일
image      varchar2(50) default 'default.PNG' ,  --상품이미지 
video      varchar2(50) default 'default.mp4',
useyn   char(1) default 'y',
content varchar2(3000)
);
create sequence movie_seq start with 1;
drop sequence movie_seq;
drop table movie purge;
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video ,useyn, content)
values(movie_seq.nextval, '블랙위도우', '케이트 쇼트랜드', '스칼렛요한슨', '1', '12', '2시간 15분', '2021-07-07', '1.PNG', '1.mp4','y','어벤져스의 히어로 블랙 위도우, ‘나타샤 로마노프’ (스칼렛 요한슨)는 자신의 과거와 연결된 레드룸의 거대한 음모와 실체를 깨닫게 된다. 상대의 능력을 복제하는 빌런 ‘태스크마스터’와 새로운 위도우들의 위협에 맞서 목숨을 건 반격을 시작하는 ‘나타샤’는 스파이로 활약했던 자신의 과거 뿐 아니라, 어벤져스가 되기 전 함께했던 동료들을 마주해야만 하는데… 폭발하는 리얼 액션 카타르시스! MCU의 새로운 시대를 시작할 첫 액션 블록버스터를 만끽하라!');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video ,useyn, content)
values(movie_seq.nextval, '루카', '엔리코 카사로사', '잭 딜런', '6', 'all', '1시간 35분', '2021-06-17', '2.PNG', '2.mp4','y', '이탈리아 리비에라의 아름다운 해변 마을, 바다 밖 세상이 궁금하지만, 두렵기도 한 호기심 많은 소년 루카 자칭 인간세상 전문가 ‘알베르토’와 함께 모험을 감행하지만, 물만 닿으면 바다 괴물로 변신하는 비밀 때문에 아슬아슬하기만 하다. 새로운 친구 ‘줄리아’와 함께 젤라또와 파스타를 실컷 먹고 스쿠터 여행을 꿈꾸는 여름은 그저 즐겁기만 한데… 과연 이들은 언제까지 비밀을 감출 수 있을까? 함께라서 행복한 여름, 우리들의 잊지 못할 모험이 시작된다!');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video ,useyn, content)
values(movie_seq.nextval, '크레센도', '드로 자하비', '괴츠 오토', '8', '12', '1시간 52분', '2021-06-24', '3.PNG', '3.mp4','y','세계적인 마에스트로 ‘에두아르트’는 평화 콘서트를 위해 오디션을 거쳐 이스라엘과 팔레스타인의 재능 있는 연주자들을 뽑는다. 수십 년간 이어온 분쟁과 갈등을 넘어 오직 음악을 바라보고 모였지만, 깊이 담겨 있던 분노와 증오는 이내 서로를 공격한다. 하나의 오케스트라를 위해 지휘자 ‘에두아르트’는 진심을 담아 노력하고 영원히 평행선을 걸을 것 같던 이들은 조금씩 서로를 이해하기 시작한다. 그러나 공연을 하루 앞두고 팔레스타인 클라리넷 연주자 ‘오마르’와 이스라엘 프렌치 호른 연주가 ‘쉬라’가 사라지는데… 오케스트라 공연은 무사히 열릴 수 있을까? 평화를 향한 희망의 멜로디가 울려 퍼진다!');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video ,useyn, content)
values(movie_seq.nextval, '크루엘라', '크레이그 질레스피', '엠마스톤', '4', '12', '2시간 13분', '2021-05-26', '4.PNG', '4.mp4','y','처음부터 난 알았어. 내가 특별하단 걸 그게 불편한 인간들도 있겠지만 모두의 비위를 맞출 수는 없잖아? 그러다 보니 결국, 학교를 계속 다닐 수가 없었지 우여곡절 런던에 오게 된 나, 에스텔라는 재스퍼와 호레이스를 운명처럼 만났고 나의 뛰어난 패션 감각을 이용해 완벽한 변장과 빠른 손놀림으로 런던 거리를 싹쓸이 했어 도둑질이 지겹게 느껴질 때쯤, 꿈에 그리던 리버티 백화점에 낙하산(?)으로 들어가게 됐어 거리를 떠돌았지만 패션을 향한 나의 열정만큼은 언제나 진심이었거든 근데 이게 뭐야, 옷에는 손도 못 대보고 하루 종일 바닥 청소라니 인내심에 한계를 느끼고 있을 때, 런던 패션계를 꽉 쥐고 있는 남작 부인이 나타났어 천재는 천재를 알아보는 법! 난 남작 부인의 브랜드 디자이너로 들어가게 되었지 꿈을 이룰 것 같았던 순간도 잠시, 세상에 남작 부인이 ‘그런 사람’이었을 줄이야… 그래서 난 내가 누군지 보여주기로 했어 잘가, 에스텔라 난 이제 크루엘라야!');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video ,useyn, content)
values(movie_seq.nextval, '빛나는 순간', '소준문', '고두심', '8', '12', '1시간 35분', '2021-06-30', '5.PNG', '5.mp4','y','‘바다에서 숨 오래 참기’로 기네스북에 오른 제주 해녀 진옥(고두심) 성질도, 물질도 제주에서 그를 이길 사람이 없다. 진옥을 취재하기 위해 서울에서 내려온 다큐멘터리 PD 경훈(지현우) 하지만 진옥의 반응은 냉담하다. 경훈은 진옥의 마음을 열기 위해 그의 주위를 맴돌기 시작하고, 진옥은 바다에 빠진 경훈의 목숨을 구해준 이후 자신과 같은 상처를 가졌음을 알고 경훈에게 마음을 연다. 제주 그리고 해녀의 삶에 깊숙이 들어가게 된 경훈 그런 경훈을 통해 진옥은 생전 처음 느껴보는 감정들을 마주하기 시작하는데… 당신을 만나고 비로소 알게 된, 나의 가장 빛나는 순간');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video ,useyn, content)
values(movie_seq.nextval, '저승보다 낯선', 'Array', 'Array', '8', '15', '1시간 19분', '2021-06-30', '6.PNG', '6.mp4','y' ,'불의의 사고로 코마에 빠진 영화감독 민우는 이상하게도 영화를 찍으려 했던 신도시 주변의 황량한 제방길을 유령처럼 떠돌고 있다. 생각 혹은 의식일지도 모르는 이곳은 번잡하고 시끄러운 삶을 살았던 그에게는 역설적이게도 천국이었다. 그러던 어느 날, 아무것도 기억하지 못하고 죽었다고 믿는 놈을 만난다. 영화이야기와 이야기를 만들려는 자의 운명을 이야기하던 민우는 젊은 나이에 죽어가는 놈의 운명에 연민을 느끼고 두 사람은 먼 듯 가까워진다. 혹시 자기가 죽었을지도 모른다는 생각에 민우는 같이 탈출해보려 하지만, 놈은 이미 이곳에 익숙해져 가고 마음의 평화를 찾아가는데… 저승 비슷한, 저승이고 하기에는 이상한, 저승이 아니라고 하기엔 낯선, 그저 텅 빈 곳에서 삶과 죽음이 존재하고 사라지고 ‘이야기’만 남는다.');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video ,useyn, content)
values(movie_seq.nextval, '발신제한', '김창주', '김지호', '2', '15', '1시간 34분', '2021-06-23', '7.PNG', '7.mp4','y','은행센터장 성규(조우진)는 아이들을 차에 태우고 출발한 평범한 출근길에 한 통의 발신번호 표시제한 전화를 받는다. 전화기 너머 의문의 목소리는 차에 폭탄이 설치되어 있고, 자리에서 일어날 경우 폭탄이 터진다고 경고하는데… 의문의 전화를 보이스피싱이라고 대수롭지 않게 여기던 성규는 곧 회사 동료의 차가 같은 방식으로 폭파되는 것을 바로 눈 앞에서 목격하고, 졸지에 부산 도심 테러의 용의자가 되어 경찰의 추격을 받게 된다. 내리면 폭탄이 터지는 절체절명의 순간, 경찰의 추격 속 의문의 발신자와의 전화마저 끊을 수 없는 상황에 놓이게 되는데…!');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video,useyn, content)
values(movie_seq.nextval, '블라이스 스피릿', '에드워드 홀', '레슬리 만', '7', '12', '1시간 39분', '2021-06-30', '8.PNG', '8.mp4','y' ,'뮤즈였던 전처 ’엘비라’의 죽음 이후 슬럼프에 빠진 작가 ‘찰스’는 영감을 얻기 위해 사랑하는 아내 ‘루스’와 함께 심령술사 ‘마담 아카티’를 찾아가 강령회를 제안한다 ‘마담 아카티’의 진지한 퍼포먼스에도 불구하고 아무 일도 일어나지 않자 다들 코웃음 쳤지만 그 날 밤, ‘찰스’ 앞에 죽은 ‘엘비라’가 나타나는데… 목숨 건 살벌한 삼각관계가 시작된다!');
insert into MOVIE(movieno, title, director, actor, genre, agegrade, playtime, opendate, image, video,useyn, content)
values(movie_seq.nextval, '미드나이트', '권오승', '진기주', '2', '15', '1시간 43분', '2021-06-30', '9.PNG', '9.mp4','y','청각장애를 가진 경미는 귀가하던 길에 피를 흘리며 쓰러져 있는 소정을 목격하고, 그녀를 도와주려다 연쇄살인마 도식의 새로운 타겟이 된다. 살고 싶다는 의지로 미친듯이 도망치는 경미 하지만 살인마의 발소리조차 들을 수 없고, 도식은 또 다른 얼굴로 나타나 경미를 위협하는데... 한밤중, 서울 한복판에서 펼쳐지는 연쇄살인마와 그의 타겟이 된 경미 의 멈출 수 없는 추격전! 극강의 음소거 추격 스릴러가 온다!');
select * from MOVIE;



drop table theaters purge;
alter table theaters drop primary key cascade;
alter table theaters drop foreign key cascade;
create table theaters(  -- 특별관(극장등급종류)
   cinemas      varchar2(50) primary key ,  -- 극장종류
   adult      number,
   child      number,
   seat         varchar2(20) default ''
);
insert into theaters(cinemas, adult, child) values('2d', 12000, 8000);
insert into theaters(cinemas, adult, child) values('4dx', 15000, 10000);
insert into theaters(cinemas, adult, child) values('starium', 18000, 13000);
insert into theaters(cinemas, adult, child) values('imax', 22000, 18000);
insert into theaters(cinemas, adult, child) values('premium', 25000, 20000);
insert into theaters(cinemas, adult, child) values('goldclass', 30000, 25000);
select * from THEATERS;



create table orders(
   orderno         number primary key, -- 주문번호
   id                  varchar2(20) references members(id),  -- 주문자아이디
   movieno       number references movie(movieno),  -- 영화번호
   quantity1      number default 0, -- 성인수량
   quantity2      number default 0, -- 소인수량
   cinemas         varchar2(50) references theaters(cinemas),  -- 극장종류
   seat            varchar2(20) default '',  -- 좌석번호
   movietime      varchar2(50) default '',  -- 상영시작시간
   moviedate      varchar2(50) default '',  -- 상영날짜
   totalprice      number default 0,  -- 금액
   orderdate      date   default sysdate  -- 주문날짜
);
create sequence orderno_seq start with 1;
drop table orders purge;
drop sequence orderno_seq;
alter table orders drop primary key cascade;
alter table orders drop foreign key cascade;
select * from orders;

(SELECT TITLE FROM movie WHERE movieno = ode.movieno ) as TITLE,

SELECT
	ode.orderno,
	ode.id,
	ode.movieno,
	(SELECT TITLE FROM movie WHERE movieno = ode.movieno ) as title,
	ode.quantity1,
	ode.quantity2,
	ode.cinemas,
	ode.seat,
	ode.movietime,
	ode.moviedate,
	ode.totalprice,
	ode.orderdate
FROM orders ode;

SELECT
	MOV.*,
	ODE.*
	
FROM MOVIE MOV
JOIN ORDERS ODE ON MOV.MOVIENO = ODE.MOVIENO;
	
	
	

	


create table qna (
  qseq        number(5)    primary key,  -- 글번호
  category    varchar2(100),            -- 카테고리  
  subject     varchar2(300),            -- 제목
  content     varchar2(1000),          -- 문의내용
  reply       varchar2(1000),           -- 답변내용
  id          varchar2(20) references members(id),                 -- 작성자(FK : member.id) 
  rep         char(1)       default '1',        --1:답변 무  2:답변 유  
  indate      date default  sysdate     -- 작성일
); 
drop table qna purge;
drop sequence qna_seq;
delete from qna;
create sequence qna_seq start with 1;

select * from qna;
insert into qna (qseq, subject, content, category, id) 
values(qna_seq.nextval, '영화관 문의입니다', '기타',  
   '영화관 내부는 많이 덥나요?', 'hong');
insert into qna (qseq, subject, content, category,id) 
values(qna_seq.nextval, '가격 문의입니다', '예매', 
   '3D관은 가격이 얼마정도 하나요?', 'hong');
insert into qna (qseq, subject, content, category, id) 
values(qna_seq.nextval, '티켓 문의입니다', '예매',
   '따로 티켓 발권을 해야하나요?', 'hana');
select * from qna where rep='1';
