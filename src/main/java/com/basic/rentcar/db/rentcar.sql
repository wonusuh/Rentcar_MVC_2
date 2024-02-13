create database rentcarDB01;
USE rentcarDB01;
-- rentcar 테이블 생성

drop table member;
CREATE TABLE rentcar(
	no INT auto_increment primary key, -- 렌트카 고유 번호 
    name VARCHAR(20), -- 차량 이름
    category INT, -- 차량 종류 
    price INT, -- 렌트 가격
    usepeople INT, -- 승차 인원
	total_qty int, -- 렌트카 총 수량 
    company VARCHAR(50), -- 차량 회사 정보
    img VARCHAR(50), -- 차량 이미지 
    info VARCHAR(500) -- 차량 정보 
);
-- member 테이블 생성
CREATE TABLE member(
	no INT auto_increment primary key, -- 고객 정보
	id VARCHAR(20), 
    pw VARCHAR(20), 
    email VARCHAR(50), 
    tel VARCHAR(20),
    hobby VARCHAR(60),
    job VARCHAR(15),
    age VARCHAR(10),
    info VARCHAR(500)
);

CREATE TABLE carreserve(
	reserve_seq INT auto_increment primary key,  -- 차량 예약 정보 번호
    no INT, -- 렌트카 고유 번호 
    id VARCHAR(50), -- 고객 id 
    qty INT, -- 렌트한 수량 
    dday INT, -- 대여기간
    rday VARCHAR(50), -- 대여일 
    usein INT, -- 운전자 보험여부
    usewifi INT, -- 인터넷 여부 
    usenavi INT, -- 네비게이션 대여 여부 
    useseat INT -- 베이비시트 적용 
);

INSERT INTO member VALUES (null,'qwer', '1234', 'qwer@naver.com', '010-2343-2444', '스포츠', '개발자', 31, '반갑습니다');
INSERT INTO member VALUES (null, 'asdf', '1234', 'qwer@naver.com', '010-2343-2444', '스포츠', '개발자', 31, '반갑습니다');
select * from member;

-- rentercar 데이터 삽입
INSERT INTO rentcar VALUES (1, '아반테', 1,  2000, 4, 10,'기아', '1.jpg' , '아반테 자동차 입니다.');
INSERT INTO rentcar VALUES (2, 'BMW', 3,  6000, 4, 1, 'BMW', '2.jpg' , 'BMW 자동차 입니다.');
INSERT INTO rentcar VALUES (3, '카니발', 1,  4000, 7, 3,'기아', '3.jpg' , '카니발 자동차 입니다.');
INSERT INTO rentcar VALUES (4, '카렌스', 2,  2500, 4, 0,'기아', '4.jpg' , '카렌스 자동차 입니다.');
INSERT INTO rentcar VALUES (5, '코란도', 1,  3000, 4, 5,'현대', '5.jpg' , '코란도 자동차 입니다.');
INSERT INTO rentcar VALUES (6, '에쿠스', 3,  6000, 4, 2,'BMW', '6.jpg' , '에쿠스 자동차 입니다.');
INSERT INTO rentcar VALUES (7, '제네시스', 1,  3000, 4, 4,'기아', '7.jpg' , '제네시스 자동차 입니다.');
INSERT INTO rentcar VALUES (8, '그랜져', 1,  2400, 4, 10,'현대', '8.jpg' , '그랜져 자동차 입니다.');
INSERT INTO rentcar VALUES (9, 'k3', 1,  2700, 4, 2,'현대', '9.jpg' , 'k3 자동차 입니다.');
INSERT INTO rentcar VALUES (10, 'k5', 2,  5000, 4, 3,'기아', '10.jpg' , 'k5 자동차 입니다.');
INSERT INTO rentcar VALUES (11, 'k9', 1,  6000, 4, 2,'현대', '11.jpg' , 'k9 자동차 입니다.');
INSERT INTO rentcar VALUES (12, '라세티', 2,  2000, 5,4, '기아', '12.jpg' , '라세티 자동차 입니다.');
INSERT INTO rentcar VALUES (13, '소나타', 1,  2000, 4, 7,'현대', '13.jpg' , 'lf소나타 자동차 입니다.');
INSERT INTO rentcar VALUES (14, '말리부', 3,  2000, 4, 8,'BMW', '14.jpg' , '말리부 자동차 입니다.');
INSERT INTO rentcar VALUES (15, '모닝', 1,  23000, 4, 9,'현대', '15.jpg' , '모닝 자동차 입니다.');
INSERT INTO rentcar VALUES (16, '올라도', 3,  5000, 4, 10,'BMW', '16.jpg' , '올라도 자동차 입니다.');
INSERT INTO rentcar VALUES (17, '레이', 2,  4000, 4, 10,'현대', '17.jpg' , '레이 자동차 입니다.');
INSERT INTO rentcar VALUES (18, 'SM5', 1,  2700, 4, 10,'BMW', '18.jpg' , 'SM5 자동차 입니다.');

select * from member;

select * from renmembertcar;
DELETE from rentcar where no=2;
SELECT * FROM rentcar ORDER BY no;
-- 최신순으로 3대의 자동차 정보 추출
SELECT * FROM rentcar ORDER BY no DESC LIMIT 3;
select count(*) from member where id = 'qwer' and pw='1234';
select * from rentcar a2 ,carreserve a1  where a1.id = 'qwer' and curdate() < date_format(a1.rday , '%y-%m-%d') and a1.no = a2.no;
select * from rentcar a2 ,carreserve a1  where a1.id = 'qwer' and a1.no = a2.no;

SELECT * FROM rentcar WHERE no=18;
INSERT INTO carreserve( no, id, qty, dday, rday, usein, usewifi, usenavi, useseat) VALUES( 1,'qwer',3, 4, sysdate() ,1,0,0,0);
update rentcar set total_qty =total_qty - 3 where no = 1;
update rentcar set total_qty =total_qty + 3 where n = 1;

select * from rentcar a2 ,carreserve a1  where a1.id = 'qwer' and a1.no = a2.no;