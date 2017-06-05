# Spring Boot���������ļ����


���źܶ���ѡ��`Spring Boot`��Ҫ�ǿ��ǵ������ܼ��Spring��ǿ���ܣ�����ʵ�ֿ��ٿ����ı�ݡ�������`Spring Boot`ʹ�ù����У���ֱ�۵ĸ��ܾ���û����ԭ���Լ�����SpringӦ��ʱ�����XML�������ݣ������������`pom.xml`������ģ�黯��`Starter POMs`�����и���ģ�鶼���Լ���Ĭ�����ã����������������Ӧ�ó�������ֻ��Ҫ��`application.properties`�����һЩ�������þ��ܿ�����ģ���Ӧ��

��֮ǰ�ĸ�ƪ�����ж����ἰ����application.properties��ʹ�ã���Ҫ�����������ݿ����ӡ���־������õȡ�������Щ��������֮�⣬���Ľ��������һЩ��application.properties�����е��������Ժ�ʹ�÷�����
# �Զ������������
### ������ʹ��Spring Boot��ʱ��ͨ��Ҳ��Ҫ����һЩ�Լ�ʹ�õ����ԣ����ǿ������·�ʽֱ�Ӷ��壺
```xml
	   com.tp.name=̷��
	   com.tp.title=Spring Boot
```
Ȼ��ͨ��@Value("${������}")ע�������ض�Ӧ���������ԣ��������£�

```xml

  @Component
public class BlogProperties {
    @Value("${com.didispace.blog.name}")
    private String name;
    @Value("${com.didispace.blog.title}")
    private String title;
    // ʡ��getter��setter
}
```
���չ�����ͨ����Ԫ��������֤BlogProperties�е������Ƿ��Ѿ����������ļ������ˡ�


```xml
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {
	@Autowired
	private BlogProperties blogProperties;
	@Test
	public void getHello() throws Exception {
		Assert.assertEquals(blogProperties.getName(), "����ԳDD");
		Assert.assertEquals(blogProperties.getTitle(), "Spring Boot�̳�");
	}
}
```
## �����������

��application.properties�еĸ�������֮��Ҳ����ֱ��������ʹ�ã�������������ã�

``` xml
com.tp.name=̷��
com.tp.title=Spring Boot�̳�
com.tp.desc=${com.tp.name}��д��${com.didispace.blog.title}��

```
com.didispace.blog.desc���������������ж����name��title���ԣ��������Ե�ֵ���ǳ���ԳDD����Ŭ��д��Spring Boot�̡̳�
### ʹ�������

��һЩ����£���Щ����������Ҫϣ��������һ���̶���ֵ��������Կ������˿ڵȡ�Spring Boot�����������ļ��п���ͨ��${random}������intֵ��longֵ����string�ַ�������֧�����Ե����ֵ��

```xml
# ����ַ���
com.didispace.blog.value=${random.value}
# ���int
com.didispace.blog.number=${random.int}
# ���long
com.didispace.blog.bignumber=${random.long}
# 10���ڵ������
com.didispace.blog.test1=${random.int(10)}
# 10-20�������
com.didispace.blog.test2=${random.int[10,20]}
```
### ͨ����������������ֵ
����ʹ�ù�һ��ʱ��Spring Boot���û���һ��֪���������`java -jar xxx.jar --server.port=8888`��ͨ��ʹ�èCserver.port����������xxx.jarӦ�õĶ˿�Ϊ8888��

������������ʱ����������������--���Ƕ�`application.properties`�е�����ֵ���и�ֵ�ı�ʶ�����ԣ�java -jar xxx.jar --server.port=8888����ȼ���������application.properties���������server.port=8888�������������������пɼ������߿�ͨ��ɾ����ֵ��ʹ�������������ø�ֵ����֤��

ͨ�����������޸�����ֵ��Ȼ�ṩ�˲���ı����ԣ�����ͨ�������о��ܸ���Ӧ�����еĲ����������Ǻܲ���ȫ���ǵģ�����Spring BootҲ���ĵ��ṩ�����������з������Ե����ã�ֻ��Ҫ������þ������Σ�`SpringApplication.setAddCommandLineProperties(false)`��
### �໷������
�����ڿ���Spring BootӦ��ʱ��ͨ��ͬһ�׳���ᱻӦ�úͰ�װ��������ͬ�Ļ��������磺���������ԡ������ȡ�����ÿ�����������ݿ��ַ���������˿ڵȵ����ö��᲻ͬ�������Ϊ��ͬ�������ʱ��ҪƵ���޸������ļ��Ļ����Ǳؽ��Ǹ��ǳ����������׷���������¡�

���ڶ໷�������ã�������Ŀ�������߻��ǿ�ܵĻ���˼·��һ�µģ�ͨ�����ö�ݲ�ͬ�����������ļ�����ͨ���������ָ����Ҫ���������֮��������ִ����Spring BootҲ�����⣬����˵���Ӽ򵥡�

��Spring Boot�ж໷�������ļ�����Ҫ����application-{profile}.properties�ĸ�ʽ������{profile}��Ӧ��Ļ�����ʶ�����磺

- application-dev.properties����������
- application-test.properties�����Ի���
- application-prod.properties����������
�����ĸ�����������ļ��ᱻ���أ���Ҫ��application.properties�ļ���ͨ��spring.profiles.active���������ã���ֵ��Ӧ{profile}ֵ��

�磺spring.profiles.active=test�ͻ����application-test.properties�����ļ�����

���棬�Բ�ͬ�������ò�ͬ�ķ���˿�Ϊ������������ʵ�顣

��Ը������½���ͬ�������ļ�application-dev.properties��application-test.properties��application-prod.properties

���������ļ��������ò�ͬ��server.port���ԣ��磺dev��������Ϊ1111��test��������Ϊ2222��prod��������Ϊ3333

application.properties������spring.profiles.active=dev������˵Ĭ����dev��������

���Բ�ͬ���õļ���

ִ��java -jar xxx.jar�����Թ۲쵽����˿ڱ�����Ϊ1111��Ҳ����Ĭ�ϵĿ���������dev��
ִ��java -jar xxx.jar --spring.profiles.active=test�����Թ۲쵽����˿ڱ�����Ϊ2222��Ҳ���ǲ��Ի��������ã�test��
ִ��java -jar xxx.jar --spring.profiles.active=prod�����Թ۲쵽����˿ڱ�����Ϊ3333��Ҳ�����������������ã�prod��
���������ʵ�飬���������ܽ�໷��������˼·��

application.properties������ͨ�����ݣ�������spring.profiles.active=dev���Կ�������ΪĬ������
application-{profile}.properties�����ø���������ͬ������
ͨ�������з�ʽȥ���ͬ����������

----------
---̷��?? 2017��6��5��16:43:30


----------


    
