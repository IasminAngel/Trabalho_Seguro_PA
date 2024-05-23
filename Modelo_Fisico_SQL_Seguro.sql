-- -----------------------------------------------------
-- Schema Trabalho_Seguro_SQL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Trabalho_Seguro_SQL` DEFAULT CHARACTER SET utf8;
USE `Trabalho_Seguro_SQL`;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`Epi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`Epi` (
  `idEpi` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `funcao` VARCHAR(45) NULL,
  `epi_ala_observacao` VARCHAR(45) NULL,
  PRIMARY KEY (`idEpi`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`Cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`Cargo` (
  `idCargo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `funcao` VARCHAR(45) NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`Funcionario` (
  `Matricula` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `Sobrenome` VARCHAR(45) NULL,
  `Dtnascimento` DATE NULL,
  `senha` VARCHAR(45) NULL,
  `Formacao` VARCHAR(45) NULL,
  `CPF` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `DDD` VARCHAR(45) NULL,
  `Bairro` VARCHAR(45) NULL,
  `Logradouro` VARCHAR(45) NULL,
  `Cidade` VARCHAR(45) NULL,
  `Telefone_Emergencial` VARCHAR(45) NULL,
  `Cargo_idCargo` INT UNSIGNED NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Matricula`),
  INDEX `fk_Funcionario_Cargo1_idx` (`Cargo_idCargo`),
  CONSTRAINT `fk_Funcionario_Cargo1`
    FOREIGN KEY (`Cargo_idCargo`)
    REFERENCES `Trabalho_Seguro_SQL`.`Cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`tem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`tem` (
  `Epi_idEpi` INT UNSIGNED NOT NULL,
  `Cargo_idCargo` INT UNSIGNED NOT NULL,
  `Funcionario_Matricula` INT NOT NULL,
  PRIMARY KEY (`Epi_idEpi`, `Cargo_idCargo`, `Funcionario_Matricula`),
  INDEX `fk_tem_Cargo1_idx` (`Cargo_idCargo`),
  INDEX `fk_tem_Epi1_idx` (`Epi_idEpi`),
  CONSTRAINT `fk_tem_Epi1`
    FOREIGN KEY (`Epi_idEpi`)
    REFERENCES `Trabalho_Seguro_SQL`.`Epi` (`idEpi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tem_Cargo1`
    FOREIGN KEY (`Cargo_idCargo`)
    REFERENCES `Trabalho_Seguro_SQL`.`Cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tem_Funcionario1`
    FOREIGN KEY (`Funcionario_Matricula`)
    REFERENCES `Trabalho_Seguro_SQL`.`Funcionario` (`Matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`Incidentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`Incidentes` (
  `idIncidentes` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(45) NULL,
  `Descricao` VARCHAR(300) NULL,
  `data` DATE NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`idIncidentes`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`Forum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`Forum` (
  `Funcionario_Matricula` INT NOT NULL,
  `Senha` VARCHAR(25) NOT NULL,
  `hora_mensagem` VARCHAR(45) NULL,
  `dt_mensagem` VARCHAR(45) NULL,
  `receptor` VARCHAR(45) NULL,
  `registros` VARCHAR(45) NULL,
  PRIMARY KEY (`Funcionario_Matricula`),
  INDEX `fk_Forum_Funcionario1_idx` (`Funcionario_Matricula`),
  CONSTRAINT `fk_Forum_Funcionario1`
    FOREIGN KEY (`Funcionario_Matricula`)
    REFERENCES `Trabalho_Seguro_SQL`.`Funcionario` (`Matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`Registra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`Registra` (
  `Incidentes_idIncidentes` INT NOT NULL,
  `Forum_Funcionario_Matricula` INT NOT NULL,
  PRIMARY KEY (`Incidentes_idIncidentes`, `Forum_Funcionario_Matricula`),
  INDEX `fk_Registra_Incidentes1_idx` (`Incidentes_idIncidentes`),
  INDEX `fk_Registra_Forum1_idx` (`Forum_Funcionario_Matricula`),
  CONSTRAINT `fk_Registra_Incidentes1`
    FOREIGN KEY (`Incidentes_idIncidentes`)
    REFERENCES `Trabalho_Seguro_SQL`.`Incidentes` (`idIncidentes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Registra_Forum1`
    FOREIGN KEY (`Forum_Funcionario_Matricula`)
    REFERENCES `Trabalho_Seguro_SQL`.`Forum` (`Funcionario_Matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Trabalho_Seguro_SQL`.`afeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Trabalho_Seguro_SQL`.`afeta` (
  `idafetados` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `sobreNome` VARCHAR(45) NULL,
  `Incidentes_idIncidentes` INT NOT NULL,
  `tem_Epi_idEpi` INT UNSIGNED NOT NULL,
  `tem_Cargo_idCargo` INT UNSIGNED NOT NULL,
  `tem_Funcionario_Matricula` INT NOT NULL,
  PRIMARY KEY (`idafetados`, `Incidentes_idIncidentes`, `tem_Epi_idEpi`, `tem_Cargo_idCargo`, `tem_Funcionario_Matricula`),
  INDEX `fk_afeta_Incidentes1_idx` (`Incidentes_idIncidentes`),
  INDEX `fk_afeta_tem1_idx` (`tem_Epi_idEpi`, `tem_Cargo_idCargo`, `tem_Funcionario_Matricula`),
  CONSTRAINT `fk_afeta_Incidentes1`
    FOREIGN KEY (`Incidentes_idIncidentes`)
    REFERENCES `Trabalho_Seguro_SQL`.`Incidentes` (`idIncidentes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_afeta_tem1`
    FOREIGN KEY (`tem_Epi_idEpi`, `tem_Cargo_idCargo`, `tem_Funcionario_Matricula`)
    REFERENCES `Trabalho_Seguro_SQL`.`tem` (`Epi_idEpi`, `Cargo_idCargo`, `Funcionario_Matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `Trabalho_Seguro_SQL`.`Epi` (`idEpi`, `nome`, `funcao`) VALUES ('1', 'Capacete', 'Proteger a  cabeça');

INSERT INTO `Trabalho_Seguro_SQL`.`Cargo` (`idCargo`, `nome`, `funcao`) VALUES ('1', 'Administradora ', 'Verificar Estoques');

INSERT INTO `Trabalho_Seguro_SQL`.`tem` (`Epi_idEpi`, `Cargo_idCargo`, `Funcionario_Matricula`) VALUES ('1', '1', '1');

INSERT INTO  `Trabalho_Seguro_SQL`.`Funcionario` (`Matricula`, `Nome`, `Sobrenome`, `Dtnascimento`, `senha`, `Formacao`, `CPF`, `numero`, `DDD`, `Bairro`, `Logradouro`, `Cidade`, `Telefone_Emergencial`, `Cargo_idCargo`,`cargo`) VALUES ('24232', 'Benedito','Silva', '1980-9-12', '123456', 'Analista de Dados', '912.242.134-90','993245422','71','Pituba','Rua dos Sentimentos 70','Salvador','(71)984343225','1','GESTOR DE EQUIPE');
INSERT INTO `trabalho_seguro_sql`.`funcionario` (`Matricula`, `Nome`, `Sobrenome`, `Dtnascimento`, `senha`, `Formacao`, `CPF`, `numero`, `DDD`, `Bairro`, `Logradouro`, `Cidade`, `Telefone_Emergencial`, `Cargo_idCargo`, `cargo`) VALUES ('31234', 'Talita', 'Matos', '1970-01-10', 'trabalho123', 'Desenvolvedor Web', '812.345.143-31', '99123651', '71', 'Valéria', 'Parque do tiro perdido 12', 'Salvador', '(71)991242312', '1', 'COLABORADOR');

UPDATE `Trabalho_Seguro_SQL`.`Cargo` SET `nome` = 'Funcionário' WHERE (`idCargo` = '1');
INSERT INTO `Trabalho_Seguro_SQL`.`Cargo` (`idCargo`, `nome`, `funcao`) VALUES ('2', 'Gestor de Equipe', 'Coodernar Ala 1');

SELECT * FROM `Trabalho_Seguro_SQL`.`Epi`;
SELECT * FROM `Trabalho_Seguro_SQL`.`Funcionario`;
SELECT * FROM `Trabalho_Seguro_SQL`.`Cargo`;
SELECT * FROM `Trabalho_Seguro_SQL`.`tem`;
SELECT * FROM `Trabalho_Seguro_SQL`.`Incidentes`;
SELECT * FROM `Trabalho_Seguro_SQL`.`Forum`;
SELECT * FROM `Trabalho_Seguro_SQL`.`Registra`;
SELECT * FROM `Trabalho_Seguro_SQL`.`afeta`;

SELECT user FROM mysql. user;
