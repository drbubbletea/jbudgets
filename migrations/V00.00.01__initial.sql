CREATE TABLE `app_user`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `email`    varchar(60)  NOT NULL,
    `password` varchar(60)  NOT NULL,
    `enabled`  char(1)      NOT NULL,
    `locked`   char(1)      NOT NULL,
    `created`  timestamp    NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`),
    UNIQUE KEY `unq_user_email` (`email`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `budget`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT,
    `workspace_id` int(11)     NOT NULL,
    `name`         varchar(40) NOT NULL,
    `created`      timestamp   NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `workspace`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT,
    `owner_user_id` int(11)     NOT NULL,
    `created`       timestamp   NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`),
    KEY `workspace_FK` (`owner_user_id`),
    CONSTRAINT `fk_workspace_user_id` FOREIGN KEY (`owner_user_id`) REFERENCES `app_user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `workspace_transaction`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT,
    `posted`       date         NOT NULL,
    `assigned`     date         NOT NULL,
    `amount`       bigint(20)   NOT NULL COMMENT 'thinking about supporting other currency types and not just USD with two decimal places',
    `description`  varchar(100) DEFAULT NULL,
    `workspace_id` int(11)      NOT NULL,
    `budget_id`    int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_transactions_workspace` (`workspace_id`),
    KEY `fk_transactions_budget_id` (`budget_id`),
    CONSTRAINT `fk_transaction_budget_id` FOREIGN KEY (`budget_id`) REFERENCES `budget` (`id`),
    CONSTRAINT `fk_transaction_workspace_id` FOREIGN KEY (`workspace_id`) REFERENCES `workspace` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;