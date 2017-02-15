package com.innovatis.lynx.platform.jpa.postgres.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditableEntity is a Querydsl query type for AuditableEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAuditableEntity extends EntityPathBase<AuditableEntity> {

    private static final long serialVersionUID = -1226270530L;

    public static final QAuditableEntity auditableEntity = new QAuditableEntity("auditableEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.util.Date> lastModifiedDate = createDateTime("lastModifiedDate", java.util.Date.class);

    public QAuditableEntity(String variable) {
        super(AuditableEntity.class, forVariable(variable));
    }

    public QAuditableEntity(Path<? extends AuditableEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditableEntity(PathMetadata metadata) {
        super(AuditableEntity.class, metadata);
    }

}

