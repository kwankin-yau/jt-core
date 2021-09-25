package info.gratour.jt808core;

import info.gratour.Timer;

import java.util.concurrent.TimeUnit;

public interface TimerProvider {

    Timer newTimer(Object key, int time, TimeUnit timeUnit, Runnable job);
}
