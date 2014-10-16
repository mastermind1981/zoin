// Hero Frank
INSERT INTO `SkillSet` (`id`) VALUES ('1');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', 'UITesting');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES ('931', 'Frank', 'Beeh', 'PrincipalConsultant', '1');

// Hero Florian
INSERT INTO `SkillSet` (`id`) VALUES ('2');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', 'Gradle');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', 'SQL');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES ('100', 'Florian', 'Besser', 'JuniorSoftwareEngineer', '2');

//Missions
INSERT INTO `SkillSet` (`id`) VALUES ('1001');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', 'SQL');
INSERT INTO `Mission` (`id`, `companyName`, `name`, `role`, `skillSet_id`) VALUES ('1', 'Swisscom', 'Junior Java Developer', 'JuniorSoftwareEngineer', '1001');

INSERT INTO `SkillSet` (`id`) VALUES ('1002');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1002', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1002', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', 'UITesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1002', 'SQL');
INSERT INTO `Mission` (`id`, `companyName`, `name`, `role`, `skillSet_id`) VALUES ('2', 'Swisscom', 'Java Architect', 'LeadSoftwareArchitect', '1002');