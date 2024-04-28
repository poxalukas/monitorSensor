-- Inserir linha de produção
INSERT INTO tb_linha_producao (id,name, status) VALUES (1,'Linha de Producao - 01', TRUE);
-- Inserir máquina relacionada à linha de produção
INSERT INTO tb_maquina (id,name, nmr_sequencia, status, linha_producao_id) VALUES (1,'Maquina - 01', 1, TRUE, 1);
-- Relacionar a máquina à linha de produção
INSERT INTO tb_linha_producao_maquinas (linha_producao_id, MAQUINAS_ID ) VALUES (1, 1);
-- Inserir sensores relacionados à máquina
INSERT INTO tb_sensor  (id,name, status, maquina_id, setpoint) VALUES(1,'sensor1', TRUE, 1, 40),(2,'sensor2', TRUE, 1, 60),(3,'sensor3', TRUE, 1, 30);
-- Relacionar os sensores à máquina
INSERT INTO TB_MAQUINA_SENSORES (maquina_id, sensores_id) VALUES (1, 1),(1, 2),(1, 3);



