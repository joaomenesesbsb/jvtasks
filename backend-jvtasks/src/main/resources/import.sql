INSERT INTO tb_user (name, email) VALUES ('Maria Brown', 'maria@gmail.com');
INSERT INTO tb_user (name, email) VALUES ('Alex Green', 'alex@gmail.com');

INSERT INTO tb_task (name,start, prompt, description, complete, creator_id) VALUES ('Estudar',TIMESTAMP WITH TIME ZONE '2023-04-10T14:00:00Z', TIMESTAMP WITH TIME ZONE '2023-05-01T15:00:00Z', '', 'true', 1);
INSERT INTO tb_task (name,start, prompt, description, complete, creator_id) VALUES ('Exercicio',TIMESTAMP WITH TIME ZONE '2023-06-23T00:00:00Z', TIMESTAMP WITH TIME ZONE '2023-07-05T15:00:00Z', '', 'false', 2);
INSERT INTO tb_task (name,start, prompt, description, complete, creator_id) VALUES ('Ler',TIMESTAMP WITH TIME ZONE '2023-02-15T15:00:00Z', TIMESTAMP WITH TIME ZONE '2023-07-15T15:00:00Z', '', 'false', 1);
INSERT INTO tb_task (name,start, prompt, description, complete, creator_id) VALUES ('Nova Skill',TIMESTAMP WITH TIME ZONE '2023-07-15T13:00:00Z', TIMESTAMP WITH TIME ZONE '2023-07-25T15:00:00Z', '', 'true', 1);