CREATE TABLE shopping_list
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255)             NOT NULL,
    created_by BIGINT                   NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_shopping_list_created_by
        FOREIGN KEY (created_by)
            REFERENCES app_user (id)
);

CREATE TABLE shopping_list_member(
    shopping_list_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,

    PRIMARY KEY (shopping_list_id),

    CONSTRAINT fk_shopping_list_member_list
        FOREIGN KEY (shopping_list_id)
        REFERENCES shopping_list(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_shopping_list_member_user
        FOREIGN KEY (user_id)
            REFERENCES app_user(id)
            ON DELETE CASCADE
);