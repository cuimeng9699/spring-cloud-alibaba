package com.example.openfeign.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationSqlConfig implements Serializable {
    private Long id;

    private String operationType;

    private String operationTable;

    private String fieldName;

    private String term;

    private String orderGroup;

    private Boolean isPage;

    private String opreationDesc;

    private Date createTime;

    private Date updateTime;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", operationType=").append(operationType);
        sb.append(", operationTable=").append(operationTable);
        sb.append(", fieldName=").append(fieldName);
        sb.append(", term=").append(term);
        sb.append(", orderGroup=").append(orderGroup);
        sb.append(", isPage=").append(isPage);
        sb.append(", opreationDesc=").append(opreationDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        operationType("operation_type", "operationType", "VARCHAR", false),
        operationTable("operation_table", "operationTable", "VARCHAR", false),
        fieldName("field_name", "fieldName", "VARCHAR", false),
        term("term", "term", "VARCHAR", false),
        orderGroup("order_group", "orderGroup", "VARCHAR", false),
        isPage("is_page", "isPage", "BIT", false),
        opreationDesc("opreation_desc", "opreationDesc", "VARCHAR", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        isDeleted("is_deleted", "isDeleted", "BIT", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}