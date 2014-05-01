#EasyDBContext Document
EasyDBContext是一个针对BAAS封装的JAVA数据库调用类，使用简单，基本零成本上手。
##Getting Start
###配置restapi.properties
请先根据你的应用做好相关配置
	
	##主要参数
	##应用程序KEY
	ApplicationKey=1234567
	##应用程序ID
	ApplicationId=123456
	

##Example

##初始化
	//初始化EasyDBContext，仅需在系统初始化的时候调用.
	EasyDBContext.init();
##新增数据
###1.插入单条数据
#####以自定义实体类的方式

	 
	 TestObject object=new TestObject();
	 EasyDBContext.insert(object);2. 

#####DBObject形式

	DBObject dbObject=new DBObject("TableName");
	dbObject.put("key",value);
	EasyDBContext.insert(object);
###2.插入多条数据

	 //自定义实体类方式
	 List<TestObject> objectList=new ArrayList<TestObject>();
	 EasyDBContext.insert(objectList);
	 //DBObject方式
	 List<DBObject> dbObjectList=new ArrayList<DBObject>();
	 //每一个DBObject不一定要同一个数据表，同样可以执行数据的插入
	 DBObject dbObject1=new DBObject("TableName1");
	 DBObject dbObject2=new DBObject("TableName2");
	 dbObjectList.add(dbObject1);
	 dbObjectList.add(dbObject2);
	 EasyDBContext.insert(dbObjectList);

