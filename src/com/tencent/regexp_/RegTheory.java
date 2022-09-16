package com.tencent.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTheory {
    public static void main(String[] args) {
        String content="1994年6、7月间，在经历了一场历时三天的讨论之后，" +
                "团队决定再一次改变了努力的目标，这次他们决定将该技术应用于万维网。" +
                "他们认为随着Mosaic浏览器的到来，因特网正在向同样的高度互动的远景演变，" +
                "而这一远景正是他们在有线电视网中看到的。作为原型，帕特里克·诺顿写了一个小" +
                "型万维网浏览器WebRunner。 [8] \n" +
                "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、" +
                "单调的静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这" +
                "种程序可以通过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投" +
                "入了大量的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并" +
                "且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，" +
                "所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上" +
                "传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的Applet（Applet是一种将" +
                "小程序嵌入到网页中进行执行的技术），并将Oak更名为Java。5月23日，Sun公司在Sun wo" +
                "rld会议上正式发布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、N" +
                "etscape和微软等各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，" +
                "并为自己的产品开发了相应的Java平台。 [9-10] ";

        Pattern pattern = Pattern.compile("(\\d\\d)(\\d\\d)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0)+" "+matcher.group(1)+" "+matcher.group(2));
        }
    }
}
