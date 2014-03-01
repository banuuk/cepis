///**
// * 
// */
//package edu.uky.cepis.model;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.faces.context.FacesContext;
//
//import org.ajax4jsf.model.DataVisitor;
//import org.ajax4jsf.model.Range;
//import org.ajax4jsf.model.SerializableDataModel;
//import org.richfaces.model.Modifiable;
//
///**
// * @author cawalk4
// * 
// */
//public abstract class PaginatingDataModel<T, U> extends SerializableDataModel implements Modifiable {
//
//	private static final long serialVersionUID = 1L;
//
//	protected U currentPk;
//	    
//	protected int rowIndex;
//	
//	protected boolean descending = true;
//	
//	protected String sortField = null;
//	    
//	protected HashMap<String,Object> filterMap = new HashMap<String,Object>();
//	
//	protected boolean detached = false;
//	
//	protected List<U> wrappedKeys = new ArrayList<U>();
//	
//	protected Integer rowCount;
//	
//	protected Map<U, T> wrappedData = new HashMap<U, T>();
//	
//	
//	@Override
//	public Object getRowKey() {
//	    return currentPk;
//	}
//
//	  
//    @SuppressWarnings("unchecked")
//    @Override
//    public void setRowKey(final Object key) {
//        this.currentPk = (U) key;
//    }
//
//	    
//    @Override
//    public void update() {
//        detached = false;
//    }
//
//	  
//    @Override
//    public SerializableDataModel getSerializableModel(final Range range) {
//        if (wrappedKeys != null) {
//            detached = true;
//            return this;
//        }
//        return null;
//    }
//
//	 
//    @Override
//    public void setRowIndex(final int arg0) {
//        rowIndex = arg0;
//    }
//
//	 
//    @Override
//    public void setWrappedData(final Object data) {
//        throw new UnsupportedOperationException();
//    }
//
//	   
//    @Override
//    public int getRowIndex() {
//        return rowIndex;
//    }
//
//	   
//    @Override
//    public Object getWrappedData() {
//        throw new UnsupportedOperationException();
//    }
//
//	   
//    @Override
//    public void walk(final FacesContext context, final DataVisitor visitor, final Range range, final Object argument)
//            throws IOException {
//        final int firstRow = ((SequenceRange) range).getFirstRow();
//        final int numberOfRows = ((SequenceRange) range).getRows();
//        if (detached) {
//            for (final U key : wrappedKeys) {
//                setRowKey(key);
//                visitor.process(context, key, argument);
//            }
//        } else { // if not serialized, than we request data from data provider
//            wrappedKeys = new ArrayList<U>();
//            for (final T object : findObjects(firstRow, numberOfRows, sortField, filterMap, descending)) {
//                wrappedKeys.add(getId(object));
//                wrappedData.put(getId(object), object);
//                visitor.process(context, getId(object), argument);
//            }
//        }
//    }
//
//    @Override
//    public boolean isRowAvailable() {
//        if (currentPk == null) {
//            return false;
//        }
//        if (wrappedKeys.contains(currentPk)) {
//            return true;
//        }
//        if (wrappedData.entrySet().contains(currentPk)) {
//            return true;
//        }
//        try {
//            if (getObjectById(currentPk) != null) {
//                return true;
//            }
//        } catch (final Exception e) {
//        }
//        return false;
//    }
//
//	   
//    @Override
//    public Object getRowData() {
//        if (currentPk == null) {
//            return null;
//        }
//        T object = wrappedData.get(currentPk);
//        if (object == null) {
//            object = getObjectById(currentPk);
//            wrappedData.put(currentPk, object);
//        }
//        return object;
//    }
//
//	    
//    @Override
//    public int getRowCount() {
//        if (rowCount == null) {
//            rowCount = getNumRecords(filterMap).intValue();
//        }
//        return rowCount;
//    }
//
//    @Override
//    public void modify(List<FilterField> filterFields, List<SortField2> sortFields) {
//        filterMap.clear();
//        SortField2 sortField2 = null;
//        String expressionStr = null;
//        ExtendedFilterField extendedFilterField = null;
//        Expression expression = null;
//        String value = null;
//        if (sortFields != null && !sortFields.isEmpty()) {
//            sortField2 = sortFields.get(0);
//            expression = sortField2.getExpression();
//            expressionStr = expression.getExpressionString();
//            if (!expression.isLiteralText()) {
//                expressionStr = expressionStr.replaceAll("[#|$]{1}\\{.*?\\.", "").replaceAll("\\}", "");
//            }
//            this.sortField = expressionStr;
//            if (sortField2.getOrdering() == Ordering.DESCENDING) {
//                this.descending = true;
//            } else {
//                this.descending = false;
//            }
//        }
//        if (filterFields != null && !filterFields.isEmpty()) {
//            for (FilterField filterField : filterFields) {
//                if (filterField instanceof ExtendedFilterField) {
//                    extendedFilterField = (ExtendedFilterField) filterField;
//                    value = extendedFilterField.getFilterValue();
//                    if (value != null && !value.equals("")) {
//                        expression = extendedFilterField.getExpression();
//                        expressionStr = expression.getExpressionString();
//                        if (!expression.isLiteralText()) {
//                            expressionStr = expressionStr.replaceAll("[#|$]{1}\\{.*?\\.", "").replaceAll("\\}", "");
//                        }
//                        filterMap.put(expressionStr, value);
//                    }
//                }
//            }
//        }
//    }
//
//	  
//    public abstract U getId(T object);
//
//	
//    public abstract List<T> findObjects(int firstRow, int numberOfRows, String sortField, HashMap<String,Object> filterMap, boolean descending);
//
//    /**
//     * 
//     * @param id
//     * 
//     * @return T
//     */
//    public abstract T getObjectById(U id);
//
//    /**
//     * 
//     * @return Long
//     */
//    public abstract Long getNumRecords(HashMap<String,Object> filterMap);
//
//	
//}
