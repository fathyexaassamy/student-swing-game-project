-- Create table
CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    wins INT DEFAULT 0,
    losses INT DEFAULT 0,
    draws INT DEFAULT 0,
    score INT DEFAULT 0
);

-- Sample data
INSERT INTO players (username, password, wins, losses, draws, score)
VALUES
('fathy', '123', 0, 0, 0, 0),
('student1', '12345', 2, 1, 0, 20),
('student2', '12345', 1, 2, 1, 13),
('student3', '12345', 0, 0, 3, 9),
('student4', '12345', 5, 0, 0, 50);