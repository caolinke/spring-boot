# spring-boot
#动态代理：
  java动态代理：需要实现InvocationHandler接口，主要通过Proxy.newProxyInstance()得到代理对象
  CGLib动态代理：不需要实现接口，代理类对象是由Enhancer类创建的，并设置回调函数
