package com.haohaoit.demo.repository.mybatis.plugins;

import org.apache.ibatis.builder.xml.XMLIncludeTransformer;
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

public class LogicalDeletePlugin extends PluginAdapter {

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
        importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getExampleType()));
        FullyQualifiedJavaType ibsreturnType = FullyQualifiedJavaType.getIntInstance();

        // deleteByExample
        Method deleteByExampleMethod = new Method("deleteByExample");
        deleteByExampleMethod.setAbstract(true);
        // 1.设置方法可见性
        deleteByExampleMethod.setVisibility(JavaVisibility.PUBLIC);
        // 2.设置返回值类型 int类型
        deleteByExampleMethod.setReturnType(ibsreturnType);
        // 3.设置参数列表
        FullyQualifiedJavaType paramType = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        deleteByExampleMethod.addParameter(new Parameter(paramType, "example"));
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(deleteByExampleMethod);

        // deleteByPrimaryKey
        Method deleteByPrimaryKeyMethod = new Method("deleteByPrimaryKey");
        deleteByPrimaryKeyMethod.setAbstract(true);
        // 1.设置方法可见性
        deleteByPrimaryKeyMethod.setVisibility(JavaVisibility.PUBLIC);
        // 2.设置返回值类型 int类型
        deleteByPrimaryKeyMethod.setReturnType(ibsreturnType);
        // 3.设置参数列表
        FullyQualifiedJavaType paramType2 = new FullyQualifiedJavaType("java.lang.Long");
        deleteByPrimaryKeyMethod.addParameter(new Parameter(paramType2, "id", "@Param(\"id\")"));
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(deleteByPrimaryKeyMethod);

        // batchDeleteByPrimaryKey
        Method batchDeleteByPrimaryKeyMethod = new Method("batchDeleteByPrimaryKey");
        batchDeleteByPrimaryKeyMethod.setAbstract(true);
        // 1.设置方法可见性
        batchDeleteByPrimaryKeyMethod.setVisibility(JavaVisibility.PUBLIC);
        // 2.设置返回值类型 int类型
        batchDeleteByPrimaryKeyMethod.setReturnType(ibsreturnType);
        // 3.设置参数列表
        FullyQualifiedJavaType paramType3 = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType paramListType = new FullyQualifiedJavaType("java.lang.Long");
        paramType3.addTypeArgument(paramListType);
        batchDeleteByPrimaryKeyMethod.addParameter(new Parameter(paramType3, "ids", "@Param(\"ids\")"));
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(batchDeleteByPrimaryKeyMethod);
    }

    /**
     * 修改Mapper.xml
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        addDeleteByExampleXml(document, introspectedTable);
        addDeleteByPrimaryKeyXml(document, introspectedTable);
        addBatchDeleteByPrimaryKeyXml(document, introspectedTable);
        return true;
    }

    private void addDeleteByExampleXml(Document document, IntrospectedTable introspectedTable) {
        XmlElement updateElement = new XmlElement("update");
        updateElement.addAttribute(new Attribute("id", "deleteByPrimaryKey"));
        updateElement.addAttribute(new Attribute("parameterType", introspectedTable.getExampleType()));
        XmlElement check = new XmlElement("if");
        check.addAttribute(new Attribute("test", "example != null"));
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "Update_By_Example_Where_Clause"));
        check.addElement(include);

        updateElement.addElement(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        updateElement.addElement(new TextElement(String.format("set %s = 1", "is_deleted")));
        updateElement.addElement(check);
        document.getRootElement().addElement(updateElement);
    }

    private void addDeleteByPrimaryKeyXml(Document document, IntrospectedTable introspectedTable) {
        XmlElement updateElement = new XmlElement("update");
        updateElement.addAttribute(new Attribute("id", "deleteByExample"));
        updateElement.addAttribute(new Attribute("parameterType", "java.lang.Long"));

        IntrospectedColumn introspectedColumn = introspectedTable.getPrimaryKeyColumns().get(0);
        TextElement whereElement = new TextElement(String.format("where %s = #{%s,jdbcType=%s}",
                introspectedColumn.getActualColumnName(),
                introspectedColumn.getJavaProperty(),
                introspectedColumn.getJdbcTypeName()));

        updateElement.addElement(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        updateElement.addElement(new TextElement(String.format("set %s = 1", "is_deleted")));
        updateElement.addElement(whereElement);
        document.getRootElement().addElement(updateElement);
    }

    private void addBatchDeleteByPrimaryKeyXml(Document document, IntrospectedTable introspectedTable) {
        XmlElement updateElement = new XmlElement("update");
        updateElement.addAttribute(new Attribute("id", "batchDeleteByPrimaryKey"));
        updateElement.addAttribute(new Attribute("parameterType", "java.util.List"));

        IntrospectedColumn introspectedColumn = introspectedTable.getPrimaryKeyColumns().get(0);
        TextElement whereElement = new TextElement(String.format("where %s in", introspectedColumn.getActualColumnName()));

        XmlElement foreachElement = new XmlElement("foreach");
        foreachElement.addAttribute(new Attribute("collection", "ids"));
        foreachElement.addAttribute(new Attribute("index", "index"));
        foreachElement.addAttribute(new Attribute("item", "id"));
        foreachElement.addAttribute(new Attribute("separator", ","));
        foreachElement.addAttribute(new Attribute("open", "("));
        foreachElement.addAttribute(new Attribute("close", ")"));
        foreachElement.addElement(new TextElement("#{id}"));

        updateElement.addElement(new TextElement("update " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
        updateElement.addElement(new TextElement(String.format("set %s = 1", "is_deleted")));
        updateElement.addElement(whereElement);
        updateElement.addElement(foreachElement);

        document.getRootElement().addElement(updateElement);
    }
}
