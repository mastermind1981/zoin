// Hero Frank
INSERT INTO `SkillSet` (`id`) VALUES ('931');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('931', 'UITesting');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES ('931', 'Frank', 'Beeh', 'PrincipalConsultant', '931');

// Hero Florian
INSERT INTO `SkillSet` (`id`) VALUES ('100');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'Gradle');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('100', 'SQL');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES ('100', 'Florian', 'Besser', 'JuniorSoftwareEngineer', '100');

//Missions
INSERT INTO `SkillSet` (`id`) VALUES ('10001');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10001', 'SQL');
INSERT INTO `Mission` (`id`, `companyName`, `name`, `role`, `skillSet_id`) VALUES ('10001', 'Swisscom', 'Junior Java Developer', 'JuniorSoftwareEngineer', '10001');

INSERT INTO `SkillSet` (`id`) VALUES ('10002');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'Java');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'Ant');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'Architektur');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'UnitTesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'UITesting');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('10002', 'SQL');
INSERT INTO `Mission` (`id`, `companyName`, `name`, `role`, `skillSet_id`) VALUES ('10002', 'Swisscom', 'Java Architect', 'LeadSoftwareArchitect', '10002');
