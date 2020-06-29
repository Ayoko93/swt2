package de.fhdo.swt.example.swtexampleapplication;

public class QueryBuilder {
    private String select;
    private String from;
    private String where;
    private String orderBy;

    public QueryBuilder from(String sourceTable, String alias)
    {
        if(from.isEmpty()){
            from = "from";
        }
        if (!alias.isEmpty()){
            from += String.format(" %s as %s", sourceTable, alias);
        }
        else{
            from += sourceTable;
        }

        return this;
    }

    public QueryBuilder join(String sourceTable, String alias){
        from += " inner join";
        from(sourceTable, alias);
        return this;
    }

    public QueryBuilder whereEqual(String columnName, String value){
        return this;
    }


    public String getQuery(){
        return String.format("%s %s %s %s", select, from, where, orderBy);
    }
}
