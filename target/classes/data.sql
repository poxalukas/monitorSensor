-- Inserir linha de produção
INSERT INTO tb_linha_producao (name, status) VALUES ('Linha de Producao - 01', TRUE);
-- Inserir máquina relacionada à linha de produção
INSERT INTO tb_maquina (name, nmr_sequencia, status, linha_producao_id) VALUES ('Maquina - 01', 1, TRUE, 1);
-- Relacionar a máquina à linha de produção
INSERT INTO TB_LINHA_PRODUCAO_MAQUINAS (linha_producao_id, maquina_id) VALUES (1, 1);
-- Inserir sensores relacionados à máquina
INSERT INTO nome_da_tabela (name, status, maquina_id, setpoint) VALUES('sensor1', TRUE, 1, 40),('sensor2', TRUE, 1, 60),('sensor3', TRUE, 1, 30);
-- Relacionar os sensores à máquina
INSERT INTO TB_MAQUINA_SENSORES (maquina_id, sensores_id) VALUES (1, 1),(1, 2),(1, 3);



