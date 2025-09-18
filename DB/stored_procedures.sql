USE cloud_vendor;

DELIMITER $$

CREATE PROCEDURE add_vote_item(IN itemName VARCHAR(100))
BEGIN
    INSERT INTO vote_item(name, votes) VALUES (itemName, 0);
END$$

CREATE PROCEDURE cast_vote(IN voterName VARCHAR(100), IN itemId INT)
BEGIN
    START TRANSACTION;
    
    -- 新增投票紀錄
    INSERT INTO vote_record(voter, item_id) VALUES (voterName, itemId);
    
    -- 更新票數
    UPDATE vote_item SET votes = votes + 1 WHERE id = itemId;
    
    COMMIT;
END$$

CREATE PROCEDURE get_all_items()
BEGIN
    SELECT id, name, votes FROM vote_item;
END$$

DELIMITER ;