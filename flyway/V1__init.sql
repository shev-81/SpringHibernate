CREATE TABLE IF NOT EXISTS students (
    id bigserial PRIMARY KEY,
    name VARCHAR(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
    );

CREATE TABLE IF NOT EXISTS courses (
    id bigserial PRIMARY KEY,
    student_id bigserial not null references students (id),
    course VARCHAR(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
    );


INSERT INTO students (name) VALUES ('Petrov'),
                                   ('Ivanov'),
                                   ('Sidorov');

INSERT INTO courses (student_id, course) VALUES (2, 'Physics'),
                                                (1, 'Physics'),
                                                (2, 'Mechanics'),
                                                (2, 'Mathematics'),
                                                (2, 'Materials Science'),
                                                (3, 'Mathematics'),
                                                (3, 'Materials Science'),
                                                (3, 'Physics');

