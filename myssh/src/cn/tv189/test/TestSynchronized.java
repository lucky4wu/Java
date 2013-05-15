package cn.tv189.test;

class TestSynchronized implements Runnable {
    String id;
    public TestSynchronized(String id)
    {
    	TestSync3.load();
        this.id=id;
    }

    public void run() {
        for(int i=0;i<10;i++){
            try
            {
                Thread mythread=new Thread();
                mythread.sleep(1000);
                TestSpring ts = TestSpring.getInstance();
                
                System.out.println(ts.toString());
                System.out.println(ts.letsdo());
//                TestSync3 sy = new TestSync3();
//                System.out.println(sy.getTMap(1));
//                System.out.println(sy.getTMap(4));
//                System.out.println(sy.getTMap(5));
//                mythread.sleep((int)(1000*Math.random()));
            }catch(InterruptedException e)
            {
                System.out.println(e.toString());
            }

            System.out.println(id+" is running");
        }

    }
    public static void main(String[] args) {
        TestSynchronized sub1 = new TestSynchronized("sub 1");
        TestSynchronized sub2 = new TestSynchronized("sub 2");
        TestSynchronized sub3 = new TestSynchronized("sub 3");
        TestSynchronized sub4 = new TestSynchronized("sub 4");
        TestSynchronized sub5 = new TestSynchronized("sub 5");
        TestSynchronized sub6 = new TestSynchronized("sub 6");
        TestSynchronized sub7 = new TestSynchronized("sub 7");
        TestSynchronized sub8 = new TestSynchronized("sub 8");
        Thread tsub1 = new Thread(sub1);
        Thread tsub2 = new Thread(sub2);
        Thread tsub3 = new Thread(sub3);
        Thread tsub4 = new Thread(sub4);
        Thread tsub5 = new Thread(sub5);
        Thread tsub6 = new Thread(sub6);
        Thread tsub7 = new Thread(sub7);
        Thread tsub8 = new Thread(sub8);
        tsub1.start();
        tsub2.start();
        tsub3.start();
        tsub4.start();
        tsub5.start();
        tsub6.start();
        tsub7.start();
        tsub8.start();
        
        try {
            Thread.sleep(1000);
            System.out.println("main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


    

