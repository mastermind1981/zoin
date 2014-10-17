// Hero Frank
INSERT INTO `SkillSet` (`id`) VALUES ('931');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'UITesting');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `picturePath`, `role`, `skillSet_id`, `educationTarget`, `zoins`) VALUES ('931', 'Frank', 'Beeh', 'img/Head12.png', 'PrincipalConsultant', '931', 'SQL', 3);

// Hero Florian
INSERT INTO `SkillSet` (`id`) VALUES ('100');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'Gradle');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'SQL');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `picturePath`, `role`, `skillSet_id`, `educationTarget`, `zoins`) VALUES ('100', 'Florian', 'Besser', 'img/Head10.png', 'JuniorSoftwareEngineer', '100', 'Architektur', 2);

// Hero Matthias Bader (kommt nicht in Frage)
INSERT INTO `SkillSet` (`id`) VALUES ('101');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('101', 'DotNet');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('101', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('101', 'SQL');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `picturePath`, `role`, `skillSet_id`, `educationTarget`, `zoins`) VALUES ('101', 'Matthias', 'Baader', 'img/Head14.png', 'SeniorSoftwareEngineer', '101', 'UITesting', 4);

// Hero Thomas Hederer (schlechter geeignet, aber interessiert)
INSERT INTO `SkillSet` (`id`) VALUES ('102');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('102', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('102', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('102', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('102', 'Gradle');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `picturePath`, `role`, `skillSet_id`, `educationTarget`) VALUES ('102', 'Thomas', 'Hederer', 'img/Head9.png', 'SeniorSoftwareEngineer', '102', 'UITesting');

// Hero Alexandro Wermer (besser geeignet, aber nicht interessiert)
INSERT INTO `SkillSet` (`id`) VALUES ('103');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('103', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('103', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('103', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('103', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('103', 'Maven');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `picturePath`, `role`, `skillSet_id`, `educationTarget`) VALUES ('103', 'Alexandro', 'Wermer', 'img/Head13.png', 'SeniorSoftwareEngineer', '103', 'UITesting');

//LCUs
INSERT INTO `LCU` (`id`, `firstName`, `lastName`) VALUES ('1', 'Wolfgang', 'Giersche');
INSERT INTO `LCU` (`id`, `firstName`, `lastName`) VALUES ('2', 'Cornel', 'Studacher');
INSERT INTO `LCU` (`id`, `firstName`, `lastName`) VALUES ('3', 'Hans', 'Meyer');

//Missions
INSERT INTO `SkillSet` (`id`) VALUES ('10001');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'SQL');
INSERT INTO `Mission` (`id`, `companyName`, `shortName`, `description`, `role`, `lcu_id`, `skillSet_id`) VALUES ('10001', 'Swisscom', 'Junior Java Developer', 'Einfache Java-Entwicklung im SAM-Team.', 'JuniorSoftwareEngineer', '1', '10001');

INSERT INTO `SkillSet` (`id`) VALUES ('10002');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'UITesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'SQL');
INSERT INTO `Mission` (`id`, `companyName`, `shortName`, `description`, `role`, `lcu_id`, `skillSet_id`) VALUES ('10002', 'Swisscom', 'Java Architect', 'Architekt für SAM-Team.', 'LeadSoftwareArchitect', '1', '10002');

INSERT INTO `SkillSet` (`id`) VALUES ('10003');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10003', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10003', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10003', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10003', 'UnitTesting');
INSERT INTO `Mission` (`id`, `companyName`, `shortName`, `description`, `role`, `lcu_id`, `skillSet_id`) VALUES ('10003', 'Swisscom', 'Senior Java Developer', 'Erfahrener Developer für die outgesourcten Teams in Schlieren.', 'SeniorSoftwareEngineer', '1', '10003');

//Medals
INSERT INTO `Medal` (`id`, `comment`, `imagePath`) VALUES ('1', 'SQL Expert', 'img/sql.png');
INSERT INTO `Medal` (`id`, `comment`, `imagePath`) VALUES ('2', 'Social Expert', 'img/social.png');
INSERT INTO `Medal` (`id`, `comment`, `imagePath`) VALUES ('3', 'Other stuff', 'img/other.png');

//Medals to Heroes
INSERT INTO `Hero_Medal` (`Hero_id`, `medals_id`) VALUES ('100', '1');
INSERT INTO `Hero_Medal` (`Hero_id`, `medals_id`) VALUES ('100', '2');
INSERT INTO `Hero_Medal` (`Hero_id`, `medals_id`) VALUES ('100', '3');
INSERT INTO `Hero_Medal` (`Hero_id`, `medals_id`) VALUES ('931', '1');

