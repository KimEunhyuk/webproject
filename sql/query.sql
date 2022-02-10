CREATE TABLE applicant (
       applicant_id         VARCHAR(20) PRIMARY KEY,
       password         	VARCHAR(20) NOT NULL,
       name               	VARCHAR(20) NOT NULL,
       phone				VARCHAR(50) NOT NULL
);

-- 종류	점수
-- sqld 10
-- adsp 15
-- dasp 20
-- bda	25
-- ipe	30
CREATE TABLE certificate (
		applicant_id        VARCHAR(20),  
		sqld 				number (3) NOT NULL,		
		adsp				number (3) NOT NULL,
		dasp				number (3) NOT NULL,
		bda					number (3) NOT NULL,
		ipe					number (3) NOT NULL,
		CONSTRAINT FK_applicant_id FOREIGN KEY(applicant_id) REFERENCES applicant(applicant_id)
);


SELECT * FROM applicant;
SELECT * FROM certificate;
DROP TABLE applicant;
DROP TABLE certificate;

INSERT INTO applicant values('test01','test01','김진주','010-000-0000');
INSERT INTO applicant values('test02','test02','김은혁','010-000-1111');
INSERT INTO applicant values('test03','test03','김영애','010-000-2222');


INSERT INTO certificate values('test01', 10, 15, 0, 0, 0);
INSERT INTO certificate values('test02', 10, 15, 20, 0, 0);
INSERT INTO certificate values('test03', 10, 0, 0, 0, 0);

COMMIT;


