package com.haohaoit.demo.repository.mybatis.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BatchUpsertPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 修改Mapper类
     */
    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {
        addBatchUpsertMethod(interfaze, introspectedTable);
        return true;
    }

    private void addBatchUpsertMethod(Interface interfaze, IntrospectedTable introspectedTable) {
        // 设置需要import的类
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
        FullyQualifiedJavaType ibsreturnType = FullyQualifiedJavaType.getIntInstance();

        // batchUpsert
        Method batchInsertMethod = new Method("batchUpsert");
        batchInsertMethod.setAbstract(true);
        // 1.设置方法可见性
        batchInsertMethod.setVisibility(JavaVisibility.PUBLIC);
        // 2.设置返回值类型 int类型
        batchInsertMethod.setReturnType(ibsreturnType);
        // 3.设置参数列表
        FullyQualifiedJavaType paramType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType paramListType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        paramType.addTypeArgument(paramListType);
        batchInsertMethod.addParameter(new Parameter(paramType, "records", "@Param(\"records\")"));
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(batchInsertMethod);
    }

    /**
     * 修改Mapper.xml
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        addBatchUpsertXml(document, introspectedTable);
        return true;
    }

    private void addBatchUpsertXml(Document document, IntrospectedTable introspectedTable) {
        // <insert ...
        XmlElement insertBatchElement = new XmlElement("insert");
        insertBatchElement.addAttribute(new Attribute("id", "batchUpsert"));
        insertBatchElement.addAttribute(new Attribute("parameterType", "java.util.List"));
        XmlElement valueTrimElement = new XmlElement("trim");
        valueTrimElement.addAttribute(new Attribute("prefix", " ("));
        valueTrimElement.addAttribute(new Attribute("suffix", ")"));
        valueTrimElement.addAttribute(new Attribute("suffixOverrides", ","));
        XmlElement columnTrimElement = new XmlElement("trim");
        columnTrimElement.addAttribute(new Attribute("prefix", "("));
        columnTrimElement.addAttribute(new Attribute("suffix", ")"));
        columnTrimElement.addAttribute(new Attribute("suffixOverrides", ","));
        XmlElement updateTrimElement = new XmlElement("trim");
        updateTrimElement.addAttribute(new Attribute("suffixOverrides", ","));
        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        for (IntrospectedColumn introspectedColumn : columns) {
            if (introspectedColumn.isIdentity()) {
                continue;
            }
            String columnName = introspectedColumn.getActualColumnName();
            columnTrimElement.addElement(new TextElement(columnName + ","));
            valueTrimElement.addElement(new TextElement("#{item." + introspectedColumn.getJavaProperty() + ",jdbcType=" + introspectedColumn.getJdbcTypeName() + "},"));
            updateTrimElement.addElement(new TextElement(String.format("%s=#{item.%s},", introspectedColumn.getActualColumnName(), introspectedColumn.getJavaProperty())));
        }
        XmlElement foreachElement = new XmlElement("foreach");
        foreachElement.addAttribute(new Attribute("collection", "records"));
        foreachElement.addAttribute(new Attribute("index", "index"));
        foreachElement.addAttribute(new Attribute("item", "item"));
        foreachElement.addAttribute(new Attribute("separator", ","));
        foreachElement.addElement(valueTrimElement);
        insertBatchElement.addElement(new TextElement("insert into " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        insertBatchElement.addElement(columnTrimElement);
        insertBatchElement.addElement(new TextElement(" values "));
        insertBatchElement.addElement(foreachElement);
        insertBatchElement.addElement(new TextElement(" on duplicate key update "));
        insertBatchElement.addElement(updateTrimElement);
        document.getRootElement().addElement(insertBatchElement);
    }
}
