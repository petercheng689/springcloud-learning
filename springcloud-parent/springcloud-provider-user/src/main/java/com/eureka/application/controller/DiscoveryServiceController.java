package com.eureka.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

/**
 * 服务发现控制类
 * 
 * @author 17542
 *
 */
@RestController
public class DiscoveryServiceController {
	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	/**
	 * 根据服务名获取主机的ip,端口
	 * 
	 * @return
	 */
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SPRINGCLOUD-PROVIDER-USER", false);
		return instance.getHomePageUrl();
	}

	/**
	 * 获取服务实例信息
	 * 
	 * @param serviceId
	 * @return
	 */
	@GetMapping("/getInstances/{serviceId}")
	public List<ServiceInstance> getInstances(@PathVariable("serviceId") String serviceId) {

		List<ServiceInstance> list = this.discoveryClient.getInstances(serviceId);

		System.out.println("------------------------------------");
		if (list != null && list.size() > 0) {
			for (ServiceInstance instance : list) {
				System.out.println("");
				System.out.println("******************************");
				System.out.println("服务实例信息：");
				System.out.println("实例id:" + instance.getInstanceId());
				System.out.println("服务 ServiceId：" + instance.getServiceId());
				System.out.println("服务 Host：" + instance.getHost());
				System.out.println("服务 Port：" + instance.getPort());
				System.out.println("服务 Uri：" + instance.getUri().toString());
				System.out.println("服务 Metadata：" + instance.getMetadata().toString());
				System.out.println("******************************");
				System.out.println("");
			}
		} else {
			System.out.println("未找到serviceId：" + serviceId + "的实例");
		}

		System.out.println("------------------------------------");
		return list;
	}

	/**
	 * 获取本地服务信息
	 * 
	 * @return
	 */
	@GetMapping("/getServices")
	public List<String> getServices() {
		List<String> list = this.discoveryClient.getServices();
		System.out.println("------------------------------------");
		if (list != null && list.size() > 0) {
			for (String serviceId : list) {
				System.out.println("服务Id : " + serviceId);
			}
		} else {
			System.out.println("注册中心无服务实例");
		}

		System.out.println("------------------------------------");
		return list;
	}

}
