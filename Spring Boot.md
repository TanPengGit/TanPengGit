#Spring Boot��������


##Spring Boot����Ҫ�ŵ㣺

* Ϊ����Spring�����߸��������
* ���伴�ã��ṩ����Ĭ������������Ŀ����
*��Ƕʽ������Web��Ŀ
*û������������ɺ�XML���õ�Ҫ��
##��������
#ʹ��Maven������Ŀ

    *ͨ��SPRING INITIALIZR���߲���������Ŀ
    * ���ʣ�http://start.spring.io/
    ѡ�񹹽�����Maven Project��Spring Boot�汾1.3.2�Լ�һЩ���̻�����Ϣ
    
    ��ѹ��Ŀ��������IDE��Maven��Ŀ���룬��IntelliJ IDEA 14Ϊ����
    
    �˵���ѡ��File�C>New�C>Project from Existing Sources...
    
    ѡ���ѹ�����Ŀ�ļ��У����OK
   
   ���Import project from external model��ѡ��Maven�����Next����Ϊֹ��
   
   ����Ļ����ж���汾��JDK��ע�⵽ѡ��Java SDK��ʱ����ѡ��Java 7���ϵİ汾
        
###ͨ�����沽������˻�����Ŀ�Ĵ���������ͼ��ʾ��Spring Boot�Ļ����ṹ�������ļ�������·�������û�������Ŀʱ��д��Group���в��죩��
src/main/java�µĳ�����ڣ�`Chapter1Application`

src/main/resources�µ������ļ���`application.properties`

src/test/�µĲ�����ڣ�`Chapter1ApplicationTests`
        
        ���ɵ�Chapter1Application��Chapter1ApplicationTests�඼����ֱ��������������ǰ��������Ŀ������Ŀǰ����Ŀδ����κ����ݷ��ʻ�Webģ�飬������ڼ�����Spring֮��������С�
        
        
##����Webģ��
��ǰ��pom.xml�������£�������������ģ�飺

spring-boot-starter������ģ�飬�����Զ�����֧�֡���־��YAML

spring-boot-starter-test������ģ�飬����JUnit��Hamcrest��Mockito


```xml

  <dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
</dependencies>
```
###����Webģ�飬�����spring-boot-starter-webģ�飺
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
##��дHelloWorld����
����package����Ϊcom.didispace.web������ʵ������޸ģ�

����HelloController�࣬��������
```java

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}

```
���������򣬴����������http://localhost:8080/hello�����Կ���ҳ�����Hello World
##��д��Ԫ��������
�򿪵�src/test/�µĲ������Chapter1ApplicationTests�ࡣ�����дһ���򵥵ĵ�Ԫ������ģ��http���󣬾������£�
```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class Chapter1ApplicationTests {
    private MockMvc mvc;
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}
}

```


ʹ��MockServletContext������һ���յ�WebApplicationContext���������Ǵ�����HelloController�Ϳ�����@Before�����д��������ݵ�MockMvcBuilders.standaloneSetup���������С�

###���������Ŀ�꣬ͨ��Maven������һ���հ�Spring Boot��Ŀ����ͨ������webģ��ʵ����һ���򵥵�������



----------
---̷��


----------


    
