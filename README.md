# Inferred TPS

## Description

Inferred TPS is a small client-sided mod that estimates the server TPS.

Or in simple words, making a guess about what is the server TPS.

AND ALSO DOESN'T NEED A SERVER SIDED MOD!

## How it works

Inferred TPS estimates the server TPS by measuring the rate of `ClientboundSetTimePacket` packets and using some simple
math.

## Commands

| Command            | What it does                            |
|--------------------|-----------------------------------------|
| /itps get          | Prints out the current TPS              |
| /itps tablist show | Displays the esimate TPS in the tablist |
| /itps tablist hide | Hides the tablist thingamajig           |

