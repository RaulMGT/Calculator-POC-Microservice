package com.poc.calculator.trace;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

/**
 * Adapter class since TracerImpl does not implement TracerAPI
 */
public class TracerImplAdapter extends TracerImpl implements TracerAPI {
}
