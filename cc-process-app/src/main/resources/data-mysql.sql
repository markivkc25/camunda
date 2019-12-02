INSERT INTO ccappdbinst.accounts(accountnumber, accounttype, creditcardnumber, customerid) VALUES('1111111111111111', 'CreditCard', '4111111111111111', 1);
INSERT INTO ccappdbinst.accounts(accountnumber, accounttype, creditcardnumber, customerid) VALUES('2012888888881881', 'CreditCard', '4012888888881881', 1);
INSERT INTO ccappdbinst.accounts(accountnumber, accounttype, creditcardnumber, customerid) VALUES('3105105105105100', 'Checking', '', 2);
INSERT INTO ccappdbinst.accounts(accountnumber, accounttype, creditcardnumber, customerid) VALUES('4111111111111111', 'CreditCard', '4111111111111111', 2);
INSERT INTO ccappdbinst.accounts(accountnumber, accounttype, creditcardnumber, customerid) VALUES('3012888888881881', 'Checking', '', 3);
INSERT INTO ccappdbinst.accounts(accountnumber, accounttype, creditcardnumber, customerid) VALUES('5105105105105100', 'CreditCard', '5105105105105100', 3);

INSERT INTO ccappdbinst.customers(username, firstname, id, lastname, password, ssn) VALUES('john.smith','John',1, 'Smith', 'V2VsY29tZUAxMjM=', '241-22-2610');
INSERT INTO ccappdbinst.customers(username, firstname, id, lastname, password, ssn) VALUES('micheal.jones','Micheal',2, 'Jones', 'V2VsY29tZUAxMjM=', '106-24-3794');
INSERT INTO ccappdbinst.customers(username, firstname, id, lastname, password, ssn) VALUES('tom.burton','Tom',3,'Burton', 'V2VsY29tZUAxMjM=', '476-30-0074');

INSERT INTO ccappdbinst.promotions(promo_code, id, promo_desc, promo_expiration_ts) VALUES('STC-1234', 1, 'Cash Rewards', '2038-01-19 03:14:08');
INSERT INTO ccappdbinst.promotions(promo_code, id, promo_desc, promo_expiration_ts) VALUES('STC-45678', 2, 'Credit Rewards', '2038-01-19 03:14:08');