USE cloud_vendor;

INSERT INTO vote_item (name, votes) VALUES 
('電腦', 0),
('滑鼠', 0),
('鍵盤', 0);

INSERT INTO vote_record (voter, item_id) VALUES
('Leo', 1),
('Sandy', 1),
('Sandy', 2),
('Randy', 2),
('RSY', 2);

UPDATE vote_item i
SET votes = (SELECT COUNT(*) FROM vote_record r WHERE r.item_id = i.id);
