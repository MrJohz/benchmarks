#!/usr/bin/env python

import time
import sys
import os
import subprocess
import statistics

times = 10
command = ["exit", "1"]

assert len(sys.argv) > 1, "benchmarker needs at least one argument to work"
if sys.argv[1].startswith("-n"):
  times = int(sys.argv[1][2:])
  assert len(sys.argv) > 2, "benchmarker needs a command to run"
  command = sys.argv[2:]
else:
  command = sys.argv[1:]

if len(command) == 1:
  command = command[0]

runtimes = []
for i in range(times):
  init_time = time.perf_counter()
  result = subprocess.call(command, stdout=subprocess.DEVNULL, shell=True)
  runtimes.append(time.perf_counter() - init_time)
  if result != 0:
    print("Program failed to execute properly.")
    print("Benchmarking will end now.")
    sys.exit(1)

print()
print("-" * 30, "\n  ", command)
print(" max/min:\t", max(runtimes), "\t", min(runtimes))
print(" mean ave:\t", statistics.mean(runtimes))
print(" median ave:\t", statistics.median(runtimes))
print("-" * 30)
