//package cn.org.harvey.s;
//
//import com.alibaba.csp.sentinel.CtSph;
//import com.alibaba.csp.sentinel.Sph;
//import com.alibaba.csp.sentinel.init.InitExecutor;
//import com.alibaba.csp.sentinel.node.NodeBuilder;
//
///**
//  *
//  * @Title: Env
//  * @Package: cn.org.harvey.s
//  * @Description: TODO (用一句话描述该文件做什么)
//  *
//  * @author harvey@xiaotitong.cn
//  * @date 2019-10-30 18:28
//  * @version V1.0
//  * Copyright (c) 2019 XTT Technogolies Co.,Ltd. All Rights Reserved.
//  */
//public class Env {
//    public static final NodeBuilder nodeBuilder = new DefaultNodeBuilder();
//    public static final Sph sph = new CtSph();
//
//    static {
//        // If init fails, the process will exit.
//        InitExecutor.doInit();
//    }
//}
