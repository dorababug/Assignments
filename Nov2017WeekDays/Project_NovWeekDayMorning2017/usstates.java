// ORM class for table 'usstates'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Feb 01 10:46:03 IST 2018
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class usstates extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String State;
  public String get_State() {
    return State;
  }
  public void set_State(String State) {
    this.State = State;
  }
  public usstates with_State(String State) {
    this.State = State;
    return this;
  }
  private String StandardAbbreviation;
  public String get_StandardAbbreviation() {
    return StandardAbbreviation;
  }
  public void set_StandardAbbreviation(String StandardAbbreviation) {
    this.StandardAbbreviation = StandardAbbreviation;
  }
  public usstates with_StandardAbbreviation(String StandardAbbreviation) {
    this.StandardAbbreviation = StandardAbbreviation;
    return this;
  }
  private String PostalCode;
  public String get_PostalCode() {
    return PostalCode;
  }
  public void set_PostalCode(String PostalCode) {
    this.PostalCode = PostalCode;
  }
  public usstates with_PostalCode(String PostalCode) {
    this.PostalCode = PostalCode;
    return this;
  }
  private String CapitalCity;
  public String get_CapitalCity() {
    return CapitalCity;
  }
  public void set_CapitalCity(String CapitalCity) {
    this.CapitalCity = CapitalCity;
  }
  public usstates with_CapitalCity(String CapitalCity) {
    this.CapitalCity = CapitalCity;
    return this;
  }
  private java.sql.Timestamp created_date;
  public java.sql.Timestamp get_created_date() {
    return created_date;
  }
  public void set_created_date(java.sql.Timestamp created_date) {
    this.created_date = created_date;
  }
  public usstates with_created_date(java.sql.Timestamp created_date) {
    this.created_date = created_date;
    return this;
  }
  private java.sql.Timestamp modified_date;
  public java.sql.Timestamp get_modified_date() {
    return modified_date;
  }
  public void set_modified_date(java.sql.Timestamp modified_date) {
    this.modified_date = modified_date;
  }
  public usstates with_modified_date(java.sql.Timestamp modified_date) {
    this.modified_date = modified_date;
    return this;
  }
  private Long id;
  public Long get_id() {
    return id;
  }
  public void set_id(Long id) {
    this.id = id;
  }
  public usstates with_id(Long id) {
    this.id = id;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof usstates)) {
      return false;
    }
    usstates that = (usstates) o;
    boolean equal = true;
    equal = equal && (this.State == null ? that.State == null : this.State.equals(that.State));
    equal = equal && (this.StandardAbbreviation == null ? that.StandardAbbreviation == null : this.StandardAbbreviation.equals(that.StandardAbbreviation));
    equal = equal && (this.PostalCode == null ? that.PostalCode == null : this.PostalCode.equals(that.PostalCode));
    equal = equal && (this.CapitalCity == null ? that.CapitalCity == null : this.CapitalCity.equals(that.CapitalCity));
    equal = equal && (this.created_date == null ? that.created_date == null : this.created_date.equals(that.created_date));
    equal = equal && (this.modified_date == null ? that.modified_date == null : this.modified_date.equals(that.modified_date));
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof usstates)) {
      return false;
    }
    usstates that = (usstates) o;
    boolean equal = true;
    equal = equal && (this.State == null ? that.State == null : this.State.equals(that.State));
    equal = equal && (this.StandardAbbreviation == null ? that.StandardAbbreviation == null : this.StandardAbbreviation.equals(that.StandardAbbreviation));
    equal = equal && (this.PostalCode == null ? that.PostalCode == null : this.PostalCode.equals(that.PostalCode));
    equal = equal && (this.CapitalCity == null ? that.CapitalCity == null : this.CapitalCity.equals(that.CapitalCity));
    equal = equal && (this.created_date == null ? that.created_date == null : this.created_date.equals(that.created_date));
    equal = equal && (this.modified_date == null ? that.modified_date == null : this.modified_date.equals(that.modified_date));
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.State = JdbcWritableBridge.readString(1, __dbResults);
    this.StandardAbbreviation = JdbcWritableBridge.readString(2, __dbResults);
    this.PostalCode = JdbcWritableBridge.readString(3, __dbResults);
    this.CapitalCity = JdbcWritableBridge.readString(4, __dbResults);
    this.created_date = JdbcWritableBridge.readTimestamp(5, __dbResults);
    this.modified_date = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.id = JdbcWritableBridge.readLong(7, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.State = JdbcWritableBridge.readString(1, __dbResults);
    this.StandardAbbreviation = JdbcWritableBridge.readString(2, __dbResults);
    this.PostalCode = JdbcWritableBridge.readString(3, __dbResults);
    this.CapitalCity = JdbcWritableBridge.readString(4, __dbResults);
    this.created_date = JdbcWritableBridge.readTimestamp(5, __dbResults);
    this.modified_date = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.id = JdbcWritableBridge.readLong(7, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(State, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(StandardAbbreviation, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PostalCode, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(CapitalCity, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(created_date, 5 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(modified_date, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeLong(id, 7 + __off, -5, __dbStmt);
    return 7;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(State, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(StandardAbbreviation, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(PostalCode, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(CapitalCity, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(created_date, 5 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(modified_date, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeLong(id, 7 + __off, -5, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.State = null;
    } else {
    this.State = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.StandardAbbreviation = null;
    } else {
    this.StandardAbbreviation = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.PostalCode = null;
    } else {
    this.PostalCode = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.CapitalCity = null;
    } else {
    this.CapitalCity = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.created_date = null;
    } else {
    this.created_date = new Timestamp(__dataIn.readLong());
    this.created_date.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.modified_date = null;
    } else {
    this.modified_date = new Timestamp(__dataIn.readLong());
    this.modified_date.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Long.valueOf(__dataIn.readLong());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.State) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, State);
    }
    if (null == this.StandardAbbreviation) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, StandardAbbreviation);
    }
    if (null == this.PostalCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PostalCode);
    }
    if (null == this.CapitalCity) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, CapitalCity);
    }
    if (null == this.created_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.created_date.getTime());
    __dataOut.writeInt(this.created_date.getNanos());
    }
    if (null == this.modified_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.modified_date.getTime());
    __dataOut.writeInt(this.modified_date.getNanos());
    }
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.id);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.State) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, State);
    }
    if (null == this.StandardAbbreviation) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, StandardAbbreviation);
    }
    if (null == this.PostalCode) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, PostalCode);
    }
    if (null == this.CapitalCity) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, CapitalCity);
    }
    if (null == this.created_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.created_date.getTime());
    __dataOut.writeInt(this.created_date.getNanos());
    }
    if (null == this.modified_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.modified_date.getTime());
    __dataOut.writeInt(this.modified_date.getNanos());
    }
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.id);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(State==null?"\\N":State, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(StandardAbbreviation==null?"\\N":StandardAbbreviation, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PostalCode==null?"\\N":PostalCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(CapitalCity==null?"\\N":CapitalCity, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(created_date==null?"\\N":"" + created_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(modified_date==null?"\\N":"" + modified_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"\\N":"" + id, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(State==null?"\\N":State, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(StandardAbbreviation==null?"\\N":StandardAbbreviation, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(PostalCode==null?"\\N":PostalCode, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(CapitalCity==null?"\\N":CapitalCity, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(created_date==null?"\\N":"" + created_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(modified_date==null?"\\N":"" + modified_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"\\N":"" + id, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.State = null; } else {
      this.State = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.StandardAbbreviation = null; } else {
      this.StandardAbbreviation = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PostalCode = null; } else {
      this.PostalCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.CapitalCity = null; } else {
      this.CapitalCity = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.created_date = null; } else {
      this.created_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.modified_date = null; } else {
      this.modified_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Long.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.State = null; } else {
      this.State = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.StandardAbbreviation = null; } else {
      this.StandardAbbreviation = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.PostalCode = null; } else {
      this.PostalCode = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.CapitalCity = null; } else {
      this.CapitalCity = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.created_date = null; } else {
      this.created_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.modified_date = null; } else {
      this.modified_date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Long.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    usstates o = (usstates) super.clone();
    o.created_date = (o.created_date != null) ? (java.sql.Timestamp) o.created_date.clone() : null;
    o.modified_date = (o.modified_date != null) ? (java.sql.Timestamp) o.modified_date.clone() : null;
    return o;
  }

  public void clone0(usstates o) throws CloneNotSupportedException {
    o.created_date = (o.created_date != null) ? (java.sql.Timestamp) o.created_date.clone() : null;
    o.modified_date = (o.modified_date != null) ? (java.sql.Timestamp) o.modified_date.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("State", this.State);
    __sqoop$field_map.put("StandardAbbreviation", this.StandardAbbreviation);
    __sqoop$field_map.put("PostalCode", this.PostalCode);
    __sqoop$field_map.put("CapitalCity", this.CapitalCity);
    __sqoop$field_map.put("created_date", this.created_date);
    __sqoop$field_map.put("modified_date", this.modified_date);
    __sqoop$field_map.put("id", this.id);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("State", this.State);
    __sqoop$field_map.put("StandardAbbreviation", this.StandardAbbreviation);
    __sqoop$field_map.put("PostalCode", this.PostalCode);
    __sqoop$field_map.put("CapitalCity", this.CapitalCity);
    __sqoop$field_map.put("created_date", this.created_date);
    __sqoop$field_map.put("modified_date", this.modified_date);
    __sqoop$field_map.put("id", this.id);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("State".equals(__fieldName)) {
      this.State = (String) __fieldVal;
    }
    else    if ("StandardAbbreviation".equals(__fieldName)) {
      this.StandardAbbreviation = (String) __fieldVal;
    }
    else    if ("PostalCode".equals(__fieldName)) {
      this.PostalCode = (String) __fieldVal;
    }
    else    if ("CapitalCity".equals(__fieldName)) {
      this.CapitalCity = (String) __fieldVal;
    }
    else    if ("created_date".equals(__fieldName)) {
      this.created_date = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("modified_date".equals(__fieldName)) {
      this.modified_date = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("id".equals(__fieldName)) {
      this.id = (Long) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("State".equals(__fieldName)) {
      this.State = (String) __fieldVal;
      return true;
    }
    else    if ("StandardAbbreviation".equals(__fieldName)) {
      this.StandardAbbreviation = (String) __fieldVal;
      return true;
    }
    else    if ("PostalCode".equals(__fieldName)) {
      this.PostalCode = (String) __fieldVal;
      return true;
    }
    else    if ("CapitalCity".equals(__fieldName)) {
      this.CapitalCity = (String) __fieldVal;
      return true;
    }
    else    if ("created_date".equals(__fieldName)) {
      this.created_date = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("modified_date".equals(__fieldName)) {
      this.modified_date = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("id".equals(__fieldName)) {
      this.id = (Long) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
