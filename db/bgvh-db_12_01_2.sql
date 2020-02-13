DROP SCHEMA IF EXISTS `bgvh_crm_db_2`;

CREATE SCHEMA IF NOT EXISTS `bgvh_crm_db_2`
CHARACTER SET `utf8`;

USE `bgvh_crm_db_2` ;

CREATE TABLE `groups` (
  `pk_group_id` TINYINT NOT NULL PRIMARY KEY,
  `group_name` VARCHAR(255) NOT NULL
  );


CREATE TABLE `profile_positions` (
  `pk_position_id` TINYINT NOT NULL PRIMARY KEY,
  `position_name` VARCHAR(255) NULL DEFAULT NULL
);


CREATE TABLE `profile_statuses` (
  `pk_status_id` TINYINT NOT NULL PRIMARY KEY,
  `status_name` VARCHAR(255) NULL DEFAULT NULL
  );

CREATE TABLE `profiles` (
  `pk_profile_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `middle_name` VARCHAR(255) NOT NULL,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `fk_group_id` TINYINT NOT NULL,
  `fk_position_id` TINYINT NOT NULL,
  `fk_status_id` TINYINT NOT NULL,

  CONSTRAINT `fk_profile_to_group` FOREIGN KEY (`fk_group_id`) REFERENCES `groups` (`pk_group_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_profile_to_position` FOREIGN KEY (`fk_position_id`) REFERENCES `profile_positions` (`pk_position_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_profile_to_status` FOREIGN KEY (`fk_status_id`) REFERENCES `profile_statuses` (`pk_status_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    );


CREATE TABLE `task_project_states` (
  `pk_status_id` TINYINT NOT NULL PRIMARY KEY,
  `status_name` VARCHAR(255) NULL DEFAULT NULL
);


CREATE TABLE `projects` (
  `pk_project_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_name` VARCHAR(255) NULL DEFAULT NULL,
  `date_of_creation` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `date_of_end` DATETIME NULL DEFAULT NULL,
  `fk_group_id` TINYINT NOT NULL,
  `fk_profile_id` INTEGER NOT NULL,
  `fk_status_id` TINYINT NOT NULL,
  
  CONSTRAINT `fk_project_to_group` FOREIGN KEY (`fk_group_id`) REFERENCES `groups` (`pk_group_id`)
	ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_project_to_profile` FOREIGN KEY (`fk_profile_id`) REFERENCES `profiles` (`pk_profile_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_project_to_status` FOREIGN KEY (`fk_status_id`) REFERENCES `task_project_statuses` (`pk_status_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);


CREATE TABLE `projects_to_profiles` (
  `fk_profile_id` INTEGER NOT NULL,
  `fk_project_id` INTEGER NOT NULL,

  CONSTRAINT `profile_to_project` FOREIGN KEY (`fk_project_id`) REFERENCES `projects` (`pk_project_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `project_to_profile` FOREIGN KEY (`fk_profile_id`) REFERENCES `profiles` (`pk_profile_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    );


CREATE TABLE `tasks` (
  `pk_task_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `task_name` VARCHAR(255) NULL DEFAULT NULL,
  `priority` TINYINT NOT NULL,
  `date_of_creation` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `date_of_end` DATETIME NULL DEFAULT NULL,
  `fk_project_id` INTEGER NOT NULL,
  `fk_profile_id` INTEGER,
  `fk_parent_task_id` INTEGER NULL DEFAULT NULL,
  `fk_status_id` TINYINT NULL DEFAULT NULL,
  
  CONSTRAINT `fk_task_to_profile` FOREIGN KEY (`fk_profile_id`) REFERENCES `profiles` (`pk_profile_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_task_to_project` FOREIGN KEY (`fk_project_id`) REFERENCES `projects` (`pk_project_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_task_to_status` FOREIGN KEY (`fk_status_id`) REFERENCES `task_project_statuses` (`pk_status_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_task_to_task` FOREIGN KEY (`fk_parent_task_id`) REFERENCES `tasks` (`pk_task_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);


CREATE TABLE `task_durations` (
  `pk_tasktime_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `start_task` TIMESTAMP NULL DEFAULT NULL,
  `stop_task` TIMESTAMP NULL DEFAULT NULL,
  `fk_task_id` INTEGER NOT NULL,
  
  CONSTRAINT `fk_tasktime_to_task` FOREIGN KEY (`fk_task_id`) REFERENCES `tasks` (`pk_task_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

