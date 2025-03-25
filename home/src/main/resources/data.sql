CREATE TABLE users (
                       username VARCHAR(50) PRIMARY KEY,  -- Là email, unique
                       password VARCHAR(255) NOT NULL,    -- Lưu mật khẩu đã mã hóa (BCrypt)
                       role VARCHAR(20) NOT NULL          -- Ví dụ: ROLE_ADMIN, ROLE_USER
);
CREATE TABLE departments (
                             dept_id INT PRIMARY KEY AUTO_INCREMENT,
                             dept_nm VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE projects (
                          project_id INT PRIMARY KEY AUTO_INCREMENT,
                          project_nm VARCHAR(50) UNIQUE NOT NULL,
                          dept_id INT NOT NULL,
                          difficulty CHAR(1) NOT NULL,   -- A, B, C, D...
                          ins_tm DATETIME DEFAULT CURRENT_TIMESTAMP,  -- Thời gian tạo
                          upd_tm DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- Thời gian cập nhật
                          version INT DEFAULT 1,
                          FOREIGN KEY (dept_id) REFERENCES departments(dept_id) ON DELETE CASCADE
);
INSERT INTO departments (dept_nm)
VALUES
    ('IT'),
    ('HR'),
    ('Finance'),
    ('Marketing'),
    ('Operations');

INSERT INTO projects (project_nm, dept_id, difficulty, version)
VALUES
    ('Project Alpha', 1, 'A', 1),
    ('Project Beta', 2, 'B', 1),
    ('Project Gamma', 3, 'C', 1),
    ('Project Delta', 1, 'A', 1),
    ('Project Epsilon', 2, 'B', 1),
    ('Project Zeta', 3, 'C', 1),
    ('Project Eta', 4, 'D', 1),
    ('Project Theta', 5, 'A', 1),
    ('Project Iota', 1, 'B', 1),
    ('Project Kappa', 2, 'C', 1);

