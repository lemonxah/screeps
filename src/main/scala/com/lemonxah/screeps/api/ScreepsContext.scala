package com.lemonxah.screeps.api

import monix.eval.Task

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
trait ImmutableIntDictionary[T] extends js.Object {
  @JSBracketAccess
  def apply(i: Int): T = js.native
}

object ImmutableIntDictionary {
  // TODO: Add wrapper to Map[Int, T]
}

@js.native
trait ScreepsContextImpl extends js.Object {
  val OK: Int
  val ERR_NOT_OWNER: Int
  val ERR_NO_PATH: Int
  val ERR_NAME_EXISTS: Int
  val ERR_BUSY: Int
  val ERR_NOT_FOUND: Int
  val ERR_NOT_ENOUGH_ENERGY: Int
  val ERR_NOT_ENOUGH_RESOURCES: Int
  val ERR_INVALID_TARGET: Int
  val ERR_FULL: Int
  val ERR_NOT_IN_RANGE: Int
  val ERR_INVALID_ARGS: Int
  val ERR_TIRED: Int
  val ERR_NO_BODYPART: Int
  val ERR_NOT_ENOUGH_EXTENSIONS: Int
  val ERR_RCL_NOT_ENOUGH: Int
  val ERR_GCL_NOT_ENOUGH: Int

  val FIND_EXIT_TOP: Int
  val FIND_EXIT_RIGHT: Int
  val FIND_EXIT_BOTTOM: Int
  val FIND_EXIT_LEFT: Int
  val FIND_EXIT: Int
  val FIND_CREEPS: Int
  val FIND_MY_CREEPS: Int
  val FIND_HOSTILE_CREEPS: Int
  val FIND_SOURCES_ACTIVE: Int
  val FIND_SOURCES: Int
  val FIND_DROPPED_ENERGY: Int
  val FIND_DROPPED_RESOURCES: Int
  val FIND_STRUCTURES: Int
  val FIND_MY_STRUCTURES: Int
  val FIND_HOSTILE_STRUCTURES: Int
  val FIND_FLAGS: Int
  val FIND_CONSTRUCTION_SITES: Int
  val FIND_MY_SPAWNS: Int
  val FIND_HOSTILE_SPAWNS: Int
  val FIND_MY_CONSTRUCTION_SITES: Int
  val FIND_HOSTILE_CONSTRUCTION_SITES: Int
  val FIND_MINERALS: Int
  val FIND_NUKES: Int

  val TOP: Int
  val TOP_RIGHT: Int
  val RIGHT: Int
  val BOTTOM_RIGHT: Int
  val BOTTOM: Int
  val BOTTOM_LEFT: Int
  val LEFT: Int
  val TOP_LEFT: Int

  val COLOR_RED: Int
  val COLOR_PURPLE: Int
  val COLOR_BLUE: Int
  val COLOR_CYAN: Int
  val COLOR_GREEN: Int
  val COLOR_YELLOW: Int
  val COLOR_ORANGE: Int
  val COLOR_BROWN: Int
  val COLOR_GREY: Int
  val COLOR_WHITE: Int

  val LOOK_CREEPS: String
  val LOOK_ENERGY: String
  val LOOK_RESOURCES: String
  val LOOK_SOURCES: String
  val LOOK_MINERALS: String
  val LOOK_STRUCTURES: String
  val LOOK_FLAGS: String
  val LOOK_CONSTRUCTION_SITES: String
  val LOOK_NUKES: String
  val LOOK_TERRAIN: String

  val OBSTACLE_OBJECT_TYPES: js.Array[String]

  val MOVE: String
  val WORK: String
  val CARRY: String
  val ATTACK: String
  val RANGED_ATTACK: String
  val TOUGH: String
  val HEAL: String
  val CLAIM: String

  val BODYPART_COST: js.Dictionary[Int]

  val CREEP_LIFE_TIME: Int
  val CREEP_CLAIM_LIFE_TIME: Int
  val CREEP_CORPSE_RATE: Double

  val CARRY_CAPACITY: Int
  val HARVEST_POWER: Int
  val HARVEST_MINERAL_POWER: Int
  val REPAIR_POWER: Int
  val DISMANTLE_POWER: Int
  val BUILD_POWER: Int
  val ATTACK_POWER: Int
  val UPGRADE_CONTROLLER_POWER: Int
  val RANGED_ATTACK_POWER: Int
  val HEAL_POWER: Int
  val RANGED_HEAL_POWER: Int
  val REPAIR_COST: Double
  val DISMANTLE_COST: Double

  val RAMPART_DECAY_AMOUNT: Int
  val RAMPART_DECAY_TIME: Int
  val RAMPART_HITS: Int
  val RAMPART_HITS_MAX: ImmutableIntDictionary[Int]

  val ENERGY_REGEN_TIME: Int
  val ENERGY_DECAY: Int

  val SPAWN_HITS: Int
  val SPAWN_ENERGY_START: Int
  val SPAWN_ENERGY_CAPACITY: Int
  val CREEP_SPAWN_TIME: Int

  val SOURCE_ENERGY_CAPACITY: Int
  val SOURCE_ENERGY_NEUTRAL_CAPACITY: Int
  val SOURCE_ENERGY_KEEPER_CAPACITY: Int

  val WALL_HITS: Int
  val WALL_HITS_MAX: Int

  val EXTENSION_HITS: Int
  val EXTENSION_ENERGY_CAPACITY: ImmutableIntDictionary[Int]

  val ROAD_HITS: Int
  val ROAD_WEAROUT: Int
  val ROAD_DECAY_AMOUNT: Int
  val ROAD_DECAY_TIME: Int

  val LINK_HITS: Int
  val LINK_HITS_MAX: Int
  val LINK_CAPACITY: Int
  val LINK_COOLDOWN: Int
  val LINK_LOSS_RATIO: Double

  val STORAGE_CAPACITY: Int
  val STORAGE_HITS: Int

  val STRUCTURE_SPAWN: String
  val STRUCTURE_EXTENSION: String
  val STRUCTURE_ROAD: String
  val STRUCTURE_WALL: String
  val STRUCTURE_RAMPART: String
  val STRUCTURE_KEEPER_LAIR: String
  val STRUCTURE_PORTAL: String
  val STRUCTURE_CONTROLLER: String
  val STRUCTURE_LINK: String
  val STRUCTURE_STORAGE: String
  val STRUCTURE_TOWER: String
  val STRUCTURE_OBSERVER: String
  val STRUCTURE_POWER_BANK: String
  val STRUCTURE_POWER_SPAWN: String
  val STRUCTURE_EXTRACTOR: String
  val STRUCTURE_LAB: String
  val STRUCTURE_TERMINAL: String
  val STRUCTURE_CONTAINER: String
  val STRUCTURE_NUKER: String

  val CONSTRUCTION_COST: js.Dictionary[Int]
  val CONSTRUCTION_COST_ROAD_SWAMP_RATIO: Int

  val CONTROLLER_LEVELS: ImmutableIntDictionary[Int]

  val CONTROLLER_STRUCTURES: js.Dictionary[ImmutableIntDictionary[Int]]
  val CONTROLLER_DOWNGRADE: ImmutableIntDictionary[Int]
  val CONTROLLER_CLAIM_DOWNGRADE: Double
  val CONTROLLER_RESERVE: Int
  val CONTROLLER_RESERVE_MAX: Int
  val CONTROLLER_MAX_UPGRADE_PER_TICK: Int
  val CONTROLLER_ATTACK_BLOCKED_UPGRADE: Int

  val TOWER_HITS: Int
  val TOWER_CAPACITY: Int
  val TOWER_ENERGY_COST: Int
  val TOWER_POWER_ATTACK: Int
  val TOWER_POWER_HEAL: Int
  val TOWER_POWER_REPAIR: Int
  val TOWER_OPTIMAL_RANGE: Int
  val TOWER_FALLOFF_RANGE: Int
  val TOWER_FALLOFF: Double

  val OBSERVER_HITS: Int
  val OBSERVER_RANGE: Int

  val POWER_BANK_HITS: Int
  val POWER_BANK_CAPACITY_MAX: Int
  val POWER_BANK_CAPACITY_MIN: Int
  val POWER_BANK_CAPACITY_CRIT: Double
  val POWER_BANK_DECAY: Int
  val POWER_BANK_HIT_BACK: Double

  val POWER_SPAWN_HITS: Int
  val POWER_SPAWN_ENERGY_CAPACITY: Int
  val POWER_SPAWN_POWER_CAPACITY: Int
  val POWER_SPAWN_ENERGY_RATIO: Int

  val EXTRACTOR_HITS: Int

  val LAB_HITS: Int
  val LAB_MINERAL_CAPACITY: Int
  val LAB_ENERGY_CAPACITY: Int
  val LAB_BOOST_ENERGY: Int
  val LAB_BOOST_MINERAL: Int
  val LAB_COOLDOWN: Int

  val GCL_POW: Double
  val GCL_MULTIPLY: Int
  val GCL_NOVICE: Int

  val MODE_SIMULATION: String
  val MODE_SURVIVAL: String
  val MODE_WORLD: String
  val MODE_ARENA: String

  val TERRAIN_MASK_WALL: Int
  val TERRAIN_MASK_SWAMP: Int
  val TERRAIN_MASK_LAVA: Int

  val MAX_CONSTRUCTION_SITES: Int
  val MAX_CREEP_SIZE: Int

  val MINERAL_REGEN_TIME: Int
  val MINERAL_MIN_AMOUNT: js.Dictionary[Int]
  val MINERAL_RANDOM_FACTOR: Int

  val TERMINAL_CAPACITY: Int
  val TERMINAL_HITS: Int
  val TERMINAL_SEND_COST: Double
  val TERMINAL_MIN_SEND: Int

  val CONTAINER_HITS: Int
  val CONTAINER_CAPACITY: Int
  val CONTAINER_DECAY: Int
  val CONTAINER_DECAY_TIME: Int
  val CONTAINER_DECAY_TIME_OWNED: Int

  val NUKER_HITS: Int
  val NUKER_COOLDOWN: Int
  val NUKER_ENERGY_CAPACITY: Int
  val NUKER_GHODIUM_CAPACITY: Int
  val NUKE_LAND_TIME: Int
  val NUKE_RANGE: Int
  val NUKE_DAMAGE: ImmutableIntDictionary[Int]

  val RESOURCE_ENERGY: String
  val RESOURCE_POWER: String

  val RESOURCE_HYDROGEN: String
  val RESOURCE_OXYGEN: String
  val RESOURCE_UTRIUM: String
  val RESOURCE_LEMERGIUM: String
  val RESOURCE_KEANIUM: String
  val RESOURCE_ZYNTHIUM: String
  val RESOURCE_CATALYST: String
  val RESOURCE_GHODIUM: String

  val RESOURCE_HYDROXIDE: String
  val RESOURCE_ZYNTHIUM_KEANITE: String
  val RESOURCE_UTRIUM_LEMERGITE: String

  val RESOURCE_UTRIUM_HYDRIDE: String
  val RESOURCE_UTRIUM_OXIDE: String
  val RESOURCE_KEANIUM_HYDRIDE: String
  val RESOURCE_KEANIUM_OXIDE: String
  val RESOURCE_LEMERGIUM_HYDRIDE: String
  val RESOURCE_LEMERGIUM_OXIDE: String
  val RESOURCE_ZYNTHIUM_HYDRIDE: String
  val RESOURCE_ZYNTHIUM_OXIDE: String
  val RESOURCE_GHODIUM_HYDRIDE: String
  val RESOURCE_GHODIUM_OXIDE: String

  val RESOURCE_UTRIUM_ACID: String
  val RESOURCE_UTRIUM_ALKALIDE: String
  val RESOURCE_KEANIUM_ACID: String
  val RESOURCE_KEANIUM_ALKALIDE: String
  val RESOURCE_LEMERGIUM_ACID: String
  val RESOURCE_LEMERGIUM_ALKALIDE: String
  val RESOURCE_ZYNTHIUM_ACID: String
  val RESOURCE_ZYNTHIUM_ALKALIDE: String
  val RESOURCE_GHODIUM_ACID: String
  val RESOURCE_GHODIUM_ALKALIDE: String

  val RESOURCE_CATALYZED_UTRIUM_ACID: String
  val RESOURCE_CATALYZED_UTRIUM_ALKALIDE: String
  val RESOURCE_CATALYZED_KEANIUM_ACID: String
  val RESOURCE_CATALYZED_KEANIUM_ALKALIDE: String
  val RESOURCE_CATALYZED_LEMERGIUM_ACID: String
  val RESOURCE_CATALYZED_LEMERGIUM_ALKALIDE: String
  val RESOURCE_CATALYZED_ZYNTHIUM_ACID: String
  val RESOURCE_CATALYZED_ZYNTHIUM_ALKALIDE: String
  val RESOURCE_CATALYZED_GHODIUM_ACID: String
  val RESOURCE_CATALYZED_GHODIUM_ALKALIDE: String

  val REACTIONS: js.Dictionary[js.Dictionary[String]]

  val BOOSTS: js.Dictionary[js.Dictionary[js.Dictionary[Double]]]

  val BODYPARTS_ALL: js.Array[String]
  val RESOURCES_ALL: js.Array[String]
  val COLORS_ALL: js.Array[Int]

  val Game: Game

  val Memory: js.Dynamic

  val RawMemory: RawMemory

  val PathFinder: PathFinder

  @JSName("console")
  val Console: Console

  val Room: RoomTypeObject

  @JSName("_")
  val LoDash: js.Dynamic
}

@js.native
trait RoomTypeObject extends js.Object {
  def deserializePath(path: String): js.Array[PathStep]
}

object ScreepsContext {
  var current: ScreepsContextImpl = null

  object RoomPosition {
    def apply(x: Int, y: Int, roomName: String) = {
      js.Dynamic.newInstance(current.asInstanceOf[js.Dynamic].RoomPosition)(x, y, roomName).asInstanceOf[RoomPosition]
    }
    def unapply(p: RoomPosition): Option[(Int, Int, String)] = Some((p.x, p.y, p.roomName))
  }

  val jsObj = js.Dynamic.literal

  def errcodeToString(e: Int) = {
    val c = current
    e match {
      case c.OK                        => "OK"
      case c.ERR_NOT_OWNER             => "Not owner"
      case c.ERR_NO_PATH               => "No path"
      case c.ERR_NAME_EXISTS           => "Name exists"
      case c.ERR_BUSY                  => "Busy"
      case c.ERR_NOT_FOUND             => "Not found"
      case c.ERR_NOT_ENOUGH_ENERGY     => "Not enough energy"
      case c.ERR_NOT_ENOUGH_RESOURCES  => "Not enough resources"
      case c.ERR_INVALID_TARGET        => "Invalid target"
      case c.ERR_FULL                  => "Full"
      case c.ERR_NOT_IN_RANGE          => "Not in range"
      case c.ERR_INVALID_ARGS          => "Invalid arguments"
      case c.ERR_TIRED                 => "Tired"
      case c.ERR_NO_BODYPART           => "No body part"
      case c.ERR_NOT_ENOUGH_EXTENSIONS => "Not enough extensions"
      case c.ERR_RCL_NOT_ENOUGH        => "Not enough RCL"
      case c.ERR_GCL_NOT_ENOUGH        => "Not enough GCL"
      case _                           => "Unknown"
    }
  }

  def OK: Int = current.OK
  def ERR_NOT_OWNER: Int = current.ERR_NOT_OWNER
  def ERR_NO_PATH: Int = current.ERR_NO_PATH
  def ERR_NAME_EXISTS: Int = current.ERR_NAME_EXISTS
  def ERR_BUSY: Int = current.ERR_BUSY
  def ERR_NOT_FOUND: Int = current.ERR_NOT_FOUND
  def ERR_NOT_ENOUGH_ENERGY: Int = current.ERR_NOT_ENOUGH_ENERGY
  def ERR_NOT_ENOUGH_RESOURCES: Int = current.ERR_NOT_ENOUGH_RESOURCES
  def ERR_INVALID_TARGET: Int = current.ERR_INVALID_TARGET
  def ERR_FULL: Int = current.ERR_FULL
  def ERR_NOT_IN_RANGE: Int = current.ERR_NOT_IN_RANGE
  def ERR_INVALID_ARGS: Int = current.ERR_INVALID_ARGS
  def ERR_TIRED: Int = current.ERR_TIRED
  def ERR_NO_BODYPART: Int = current.ERR_NO_BODYPART
  def ERR_NOT_ENOUGH_EXTENSIONS: Int = current.ERR_NOT_ENOUGH_EXTENSIONS
  def ERR_RCL_NOT_ENOUGH: Int = current.ERR_RCL_NOT_ENOUGH
  def ERR_GCL_NOT_ENOUGH: Int = current.ERR_GCL_NOT_ENOUGH

  def FIND_EXIT_TOP: Int = current.FIND_EXIT_TOP
  def FIND_EXIT_RIGHT: Int = current.FIND_EXIT_RIGHT
  def FIND_EXIT_BOTTOM: Int = current.FIND_EXIT_BOTTOM
  def FIND_EXIT_LEFT: Int = current.FIND_EXIT_LEFT
  def FIND_EXIT: Int = current.FIND_EXIT
  def FIND_CREEPS: Int = current.FIND_CREEPS
  def FIND_MY_CREEPS: Int = current.FIND_MY_CREEPS
  def FIND_HOSTILE_CREEPS: Int = current.FIND_HOSTILE_CREEPS
  def FIND_SOURCES_ACTIVE: Int = current.FIND_SOURCES_ACTIVE
  def FIND_SOURCES: Int = current.FIND_SOURCES
  def FIND_DROPPED_ENERGY: Int = current.FIND_DROPPED_ENERGY
  def FIND_DROPPED_RESOURCES: Int = current.FIND_DROPPED_RESOURCES
  def FIND_STRUCTURES: Int = current.FIND_STRUCTURES
  def FIND_MY_STRUCTURES: Int = current.FIND_MY_STRUCTURES
  def FIND_HOSTILE_STRUCTURES: Int = current.FIND_HOSTILE_STRUCTURES
  def FIND_FLAGS: Int = current.FIND_FLAGS
  def FIND_CONSTRUCTION_SITES: Int = current.FIND_CONSTRUCTION_SITES
  def FIND_MY_SPAWNS: Int = current.FIND_MY_SPAWNS
  def FIND_HOSTILE_SPAWNS: Int = current.FIND_HOSTILE_SPAWNS
  def FIND_MY_CONSTRUCTION_SITES: Int = current.FIND_MY_CONSTRUCTION_SITES
  def FIND_HOSTILE_CONSTRUCTION_SITES: Int = current.FIND_HOSTILE_CONSTRUCTION_SITES
  def FIND_MINERALS: Int = current.FIND_MINERALS
  def FIND_NUKES: Int = current.FIND_NUKES

  def TOP: Int = current.TOP
  def TOP_RIGHT: Int = current.TOP_RIGHT
  def RIGHT: Int = current.RIGHT
  def BOTTOM_RIGHT: Int = current.BOTTOM_RIGHT
  def BOTTOM: Int = current.BOTTOM
  def BOTTOM_LEFT: Int = current.BOTTOM_LEFT
  def LEFT: Int = current.LEFT
  def TOP_LEFT: Int = current.TOP_LEFT

  def COLOR_RED: Int = current.COLOR_RED
  def COLOR_PURPLE: Int = current.COLOR_PURPLE
  def COLOR_BLUE: Int = current.COLOR_BLUE
  def COLOR_CYAN: Int = current.COLOR_CYAN
  def COLOR_GREEN: Int = current.COLOR_GREEN
  def COLOR_YELLOW: Int = current.COLOR_YELLOW
  def COLOR_ORANGE: Int = current.COLOR_ORANGE
  def COLOR_BROWN: Int = current.COLOR_BROWN
  def COLOR_GREY: Int = current.COLOR_GREY
  def COLOR_WHITE: Int = current.COLOR_WHITE

  def LOOK_CREEPS: String = current.LOOK_CREEPS
  def LOOK_ENERGY: String = current.LOOK_ENERGY
  def LOOK_RESOURCES: String = current.LOOK_RESOURCES
  def LOOK_SOURCES: String = current.LOOK_SOURCES
  def LOOK_MINERALS: String = current.LOOK_MINERALS
  def LOOK_STRUCTURES: String = current.LOOK_STRUCTURES
  def LOOK_FLAGS: String = current.LOOK_FLAGS
  def LOOK_CONSTRUCTION_SITES: String = current.LOOK_CONSTRUCTION_SITES
  def LOOK_NUKES: String = current.LOOK_NUKES
  def LOOK_TERRAIN: String = current.LOOK_TERRAIN

  def OBSTACLE_OBJECT_TYPES: js.Array[String] = current.OBSTACLE_OBJECT_TYPES

  def MOVE: String = current.MOVE
  def WORK: String = current.WORK
  def CARRY: String = current.CARRY
  def ATTACK: String = current.ATTACK
  def RANGED_ATTACK: String = current.RANGED_ATTACK
  def TOUGH: String = current.TOUGH
  def HEAL: String = current.HEAL
  def CLAIM: String = current.CLAIM

  def BODYPART_COST: js.Dictionary[Int] = current.BODYPART_COST

  def CREEP_LIFE_TIME: Int = current.CREEP_LIFE_TIME
  def CREEP_CLAIM_LIFE_TIME: Int = current.CREEP_CLAIM_LIFE_TIME
  def CREEP_CORPSE_RATE: Double = current.CREEP_CORPSE_RATE

  def CARRY_CAPACITY: Int = current.CARRY_CAPACITY
  def HARVEST_POWER: Int = current.HARVEST_POWER
  def HARVEST_MINERAL_POWER: Int = current.HARVEST_MINERAL_POWER
  def REPAIR_POWER: Int = current.REPAIR_POWER
  def DISMANTLE_POWER: Int = current.DISMANTLE_POWER
  def BUILD_POWER: Int = current.BUILD_POWER
  def ATTACK_POWER: Int = current.ATTACK_POWER
  def UPGRADE_CONTROLLER_POWER: Int = current.UPGRADE_CONTROLLER_POWER
  def RANGED_ATTACK_POWER: Int = current.RANGED_ATTACK_POWER
  def HEAL_POWER: Int = current.HEAL_POWER
  def RANGED_HEAL_POWER: Int = current.RANGED_HEAL_POWER
  def REPAIR_COST: Double = current.REPAIR_COST
  def DISMANTLE_COST: Double = current.DISMANTLE_COST

  def RAMPART_DECAY_AMOUNT: Int = current.RAMPART_DECAY_AMOUNT
  def RAMPART_DECAY_TIME: Int = current.RAMPART_DECAY_TIME
  def RAMPART_HITS: Int = current.RAMPART_HITS
  def RAMPART_HITS_MAX: ImmutableIntDictionary[Int] = current.RAMPART_HITS_MAX

  def ENERGY_REGEN_TIME: Int = current.ENERGY_REGEN_TIME
  def ENERGY_DECAY: Int = current.ENERGY_DECAY

  def SPAWN_HITS: Int = current.SPAWN_HITS
  def SPAWN_ENERGY_START: Int = current.SPAWN_ENERGY_START
  def SPAWN_ENERGY_CAPACITY: Int = current.SPAWN_ENERGY_CAPACITY
  def CREEP_SPAWN_TIME: Int = current.CREEP_SPAWN_TIME

  def SOURCE_ENERGY_CAPACITY: Int = current.SOURCE_ENERGY_CAPACITY
  def SOURCE_ENERGY_NEUTRAL_CAPACITY: Int = current.SOURCE_ENERGY_NEUTRAL_CAPACITY
  def SOURCE_ENERGY_KEEPER_CAPACITY: Int = current.SOURCE_ENERGY_KEEPER_CAPACITY

  def WALL_HITS: Int = current.WALL_HITS
  def WALL_HITS_MAX: Int = current.WALL_HITS_MAX

  def EXTENSION_HITS: Int = current.EXTENSION_HITS
  def EXTENSION_ENERGY_CAPACITY: ImmutableIntDictionary[Int] = current.EXTENSION_ENERGY_CAPACITY

  def ROAD_HITS: Int = current.ROAD_HITS
  def ROAD_WEAROUT: Int = current.ROAD_WEAROUT
  def ROAD_DECAY_AMOUNT: Int = current.ROAD_DECAY_AMOUNT
  def ROAD_DECAY_TIME: Int = current.ROAD_DECAY_TIME

  def LINK_HITS: Int = current.LINK_HITS
  def LINK_HITS_MAX: Int = current.LINK_HITS_MAX
  def LINK_CAPACITY: Int = current.LINK_CAPACITY
  def LINK_COOLDOWN: Int = current.LINK_COOLDOWN
  def LINK_LOSS_RATIO: Double = current.LINK_LOSS_RATIO

  def STORAGE_CAPACITY: Int = current.STORAGE_CAPACITY
  def STORAGE_HITS: Int = current.STORAGE_HITS

  def STRUCTURE_SPAWN: String = current.STRUCTURE_SPAWN
  def STRUCTURE_EXTENSION: String = current.STRUCTURE_EXTENSION
  def STRUCTURE_ROAD: String = current.STRUCTURE_ROAD
  def STRUCTURE_WALL: String = current.STRUCTURE_WALL
  def STRUCTURE_RAMPART: String = current.STRUCTURE_RAMPART
  def STRUCTURE_KEEPER_LAIR: String = current.STRUCTURE_KEEPER_LAIR
  def STRUCTURE_PORTAL: String = current.STRUCTURE_PORTAL
  def STRUCTURE_CONTROLLER: String = current.STRUCTURE_CONTROLLER
  def STRUCTURE_LINK: String = current.STRUCTURE_LINK
  def STRUCTURE_STORAGE: String = current.STRUCTURE_STORAGE
  def STRUCTURE_TOWER: String = current.STRUCTURE_TOWER
  def STRUCTURE_OBSERVER: String = current.STRUCTURE_OBSERVER
  def STRUCTURE_POWER_BANK: String = current.STRUCTURE_POWER_BANK
  def STRUCTURE_POWER_SPAWN: String = current.STRUCTURE_POWER_SPAWN
  def STRUCTURE_EXTRACTOR: String = current.STRUCTURE_EXTRACTOR
  def STRUCTURE_LAB: String = current.STRUCTURE_LAB
  def STRUCTURE_TERMINAL: String = current.STRUCTURE_TERMINAL
  def STRUCTURE_CONTAINER: String = current.STRUCTURE_CONTAINER
  def STRUCTURE_NUKER: String = current.STRUCTURE_NUKER

  def CONSTRUCTION_COST: js.Dictionary[Int] = current.CONSTRUCTION_COST
  def CONSTRUCTION_COST_ROAD_SWAMP_RATIO: Int = current.CONSTRUCTION_COST_ROAD_SWAMP_RATIO

  def CONTROLLER_LEVELS: ImmutableIntDictionary[Int] = current.CONTROLLER_LEVELS

  def CONTROLLER_STRUCTURES: js.Dictionary[ImmutableIntDictionary[Int]] = current.CONTROLLER_STRUCTURES
  def CONTROLLER_DOWNGRADE: ImmutableIntDictionary[Int] = current.CONTROLLER_DOWNGRADE
  def CONTROLLER_CLAIM_DOWNGRADE: Double = current.CONTROLLER_CLAIM_DOWNGRADE
  def CONTROLLER_RESERVE: Int = current.CONTROLLER_RESERVE
  def CONTROLLER_RESERVE_MAX: Int = current.CONTROLLER_RESERVE_MAX
  def CONTROLLER_MAX_UPGRADE_PER_TICK: Int = current.CONTROLLER_MAX_UPGRADE_PER_TICK
  def CONTROLLER_ATTACK_BLOCKED_UPGRADE: Int = current.CONTROLLER_ATTACK_BLOCKED_UPGRADE

  def TOWER_HITS: Int = current.TOWER_HITS
  def TOWER_CAPACITY: Int = current.TOWER_CAPACITY
  def TOWER_ENERGY_COST: Int = current.TOWER_ENERGY_COST
  def TOWER_POWER_ATTACK: Int = current.TOWER_POWER_ATTACK
  def TOWER_POWER_HEAL: Int = current.TOWER_POWER_HEAL
  def TOWER_POWER_REPAIR: Int = current.TOWER_POWER_REPAIR
  def TOWER_OPTIMAL_RANGE: Int = current.TOWER_OPTIMAL_RANGE
  def TOWER_FALLOFF_RANGE: Int = current.TOWER_FALLOFF_RANGE
  def TOWER_FALLOFF: Double = current.TOWER_FALLOFF

  def OBSERVER_HITS: Int = current.OBSERVER_HITS
  def OBSERVER_RANGE: Int = current.OBSERVER_RANGE

  def POWER_BANK_HITS: Int = current.POWER_BANK_HITS
  def POWER_BANK_CAPACITY_MAX: Int = current.POWER_BANK_CAPACITY_MAX
  def POWER_BANK_CAPACITY_MIN: Int = current.POWER_BANK_CAPACITY_MIN
  def POWER_BANK_CAPACITY_CRIT: Double = current.POWER_BANK_CAPACITY_CRIT
  def POWER_BANK_DECAY: Int = current.POWER_BANK_DECAY
  def POWER_BANK_HIT_BACK: Double = current.POWER_BANK_HIT_BACK

  def POWER_SPAWN_HITS: Int = current.POWER_SPAWN_HITS
  def POWER_SPAWN_ENERGY_CAPACITY: Int = current.POWER_SPAWN_ENERGY_CAPACITY
  def POWER_SPAWN_POWER_CAPACITY: Int = current.POWER_SPAWN_POWER_CAPACITY
  def POWER_SPAWN_ENERGY_RATIO: Int = current.POWER_SPAWN_ENERGY_RATIO

  def EXTRACTOR_HITS: Int = current.EXTRACTOR_HITS

  def LAB_HITS: Int = current.LAB_HITS
  def LAB_MINERAL_CAPACITY: Int = current.LAB_MINERAL_CAPACITY
  def LAB_ENERGY_CAPACITY: Int = current.LAB_ENERGY_CAPACITY
  def LAB_BOOST_ENERGY: Int = current.LAB_BOOST_ENERGY
  def LAB_BOOST_MINERAL: Int = current.LAB_BOOST_MINERAL
  def LAB_COOLDOWN: Int = current.LAB_COOLDOWN

  def GCL_POW: Double = current.GCL_POW
  def GCL_MULTIPLY: Int = current.GCL_MULTIPLY
  def GCL_NOVICE: Int = current.GCL_NOVICE

  def MODE_SIMULATION: String = current.MODE_SIMULATION
  def MODE_SURVIVAL: String = current.MODE_SURVIVAL
  def MODE_WORLD: String = current.MODE_WORLD
  def MODE_ARENA: String = current.MODE_ARENA

  def TERRAIN_MASK_WALL: Int = current.TERRAIN_MASK_WALL
  def TERRAIN_MASK_SWAMP: Int = current.TERRAIN_MASK_SWAMP
  def TERRAIN_MASK_LAVA: Int = current.TERRAIN_MASK_LAVA

  def MAX_CONSTRUCTION_SITES: Int = current.MAX_CONSTRUCTION_SITES
  def MAX_CREEP_SIZE: Int = current.MAX_CREEP_SIZE

  def MINERAL_REGEN_TIME: Int = current.MINERAL_REGEN_TIME
  def MINERAL_MIN_AMOUNT: js.Dictionary[Int] = current.MINERAL_MIN_AMOUNT
  def MINERAL_RANDOM_FACTOR: Int = current.MINERAL_RANDOM_FACTOR

  def TERMINAL_CAPACITY: Int = current.TERMINAL_CAPACITY
  def TERMINAL_HITS: Int = current.TERMINAL_HITS
  def TERMINAL_SEND_COST: Double = current.TERMINAL_SEND_COST
  def TERMINAL_MIN_SEND: Int = current.TERMINAL_MIN_SEND

  def CONTAINER_HITS: Int = current.CONTAINER_HITS
  def CONTAINER_CAPACITY: Int = current.CONTAINER_CAPACITY
  def CONTAINER_DECAY: Int = current.CONTAINER_DECAY
  def CONTAINER_DECAY_TIME: Int = current.CONTAINER_DECAY_TIME
  def CONTAINER_DECAY_TIME_OWNED: Int = current.CONTAINER_DECAY_TIME_OWNED

  def NUKER_HITS: Int = current.NUKER_HITS
  def NUKER_COOLDOWN: Int = current.NUKER_COOLDOWN
  def NUKER_ENERGY_CAPACITY: Int = current.NUKER_ENERGY_CAPACITY
  def NUKER_GHODIUM_CAPACITY: Int = current.NUKER_GHODIUM_CAPACITY
  def NUKE_LAND_TIME: Int = current.NUKE_LAND_TIME
  def NUKE_RANGE: Int = current.NUKE_RANGE
  def NUKE_DAMAGE: ImmutableIntDictionary[Int] = current.NUKE_DAMAGE

  def RESOURCE_ENERGY: String = current.RESOURCE_ENERGY
  def RESOURCE_POWER: String = current.RESOURCE_POWER

  def RESOURCE_HYDROGEN: String = current.RESOURCE_HYDROGEN
  def RESOURCE_OXYGEN: String = current.RESOURCE_OXYGEN
  def RESOURCE_UTRIUM: String = current.RESOURCE_UTRIUM
  def RESOURCE_LEMERGIUM: String = current.RESOURCE_LEMERGIUM
  def RESOURCE_KEANIUM: String = current.RESOURCE_KEANIUM
  def RESOURCE_ZYNTHIUM: String = current.RESOURCE_ZYNTHIUM
  def RESOURCE_CATALYST: String = current.RESOURCE_CATALYST
  def RESOURCE_GHODIUM: String = current.RESOURCE_GHODIUM

  def RESOURCE_HYDROXIDE: String = current.RESOURCE_HYDROXIDE
  def RESOURCE_ZYNTHIUM_KEANITE: String = current.RESOURCE_ZYNTHIUM_KEANITE
  def RESOURCE_UTRIUM_LEMERGITE: String = current.RESOURCE_UTRIUM_LEMERGITE

  def RESOURCE_UTRIUM_HYDRIDE: String = current.RESOURCE_UTRIUM_HYDRIDE
  def RESOURCE_UTRIUM_OXIDE: String = current.RESOURCE_UTRIUM_OXIDE
  def RESOURCE_KEANIUM_HYDRIDE: String = current.RESOURCE_KEANIUM_HYDRIDE
  def RESOURCE_KEANIUM_OXIDE: String = current.RESOURCE_KEANIUM_OXIDE
  def RESOURCE_LEMERGIUM_HYDRIDE: String = current.RESOURCE_LEMERGIUM_HYDRIDE
  def RESOURCE_LEMERGIUM_OXIDE: String = current.RESOURCE_LEMERGIUM_OXIDE
  def RESOURCE_ZYNTHIUM_HYDRIDE: String = current.RESOURCE_ZYNTHIUM_HYDRIDE
  def RESOURCE_ZYNTHIUM_OXIDE: String = current.RESOURCE_ZYNTHIUM_OXIDE
  def RESOURCE_GHODIUM_HYDRIDE: String = current.RESOURCE_GHODIUM_HYDRIDE
  def RESOURCE_GHODIUM_OXIDE: String = current.RESOURCE_GHODIUM_OXIDE

  def RESOURCE_UTRIUM_ACID: String = current.RESOURCE_UTRIUM_ACID
  def RESOURCE_UTRIUM_ALKALIDE: String = current.RESOURCE_UTRIUM_ALKALIDE
  def RESOURCE_KEANIUM_ACID: String = current.RESOURCE_KEANIUM_ACID
  def RESOURCE_KEANIUM_ALKALIDE: String = current.RESOURCE_KEANIUM_ALKALIDE
  def RESOURCE_LEMERGIUM_ACID: String = current.RESOURCE_LEMERGIUM_ACID
  def RESOURCE_LEMERGIUM_ALKALIDE: String = current.RESOURCE_LEMERGIUM_ALKALIDE
  def RESOURCE_ZYNTHIUM_ACID: String = current.RESOURCE_ZYNTHIUM_ACID
  def RESOURCE_ZYNTHIUM_ALKALIDE: String = current.RESOURCE_ZYNTHIUM_ALKALIDE
  def RESOURCE_GHODIUM_ACID: String = current.RESOURCE_GHODIUM_ACID
  def RESOURCE_GHODIUM_ALKALIDE: String = current.RESOURCE_GHODIUM_ALKALIDE

  def RESOURCE_CATALYZED_UTRIUM_ACID: String = current.RESOURCE_CATALYZED_UTRIUM_ACID
  def RESOURCE_CATALYZED_UTRIUM_ALKALIDE: String = current.RESOURCE_CATALYZED_UTRIUM_ALKALIDE
  def RESOURCE_CATALYZED_KEANIUM_ACID: String = current.RESOURCE_CATALYZED_KEANIUM_ACID
  def RESOURCE_CATALYZED_KEANIUM_ALKALIDE: String = current.RESOURCE_CATALYZED_KEANIUM_ALKALIDE
  def RESOURCE_CATALYZED_LEMERGIUM_ACID: String = current.RESOURCE_CATALYZED_LEMERGIUM_ACID
  def RESOURCE_CATALYZED_LEMERGIUM_ALKALIDE: String = current.RESOURCE_CATALYZED_LEMERGIUM_ALKALIDE
  def RESOURCE_CATALYZED_ZYNTHIUM_ACID: String = current.RESOURCE_CATALYZED_ZYNTHIUM_ACID
  def RESOURCE_CATALYZED_ZYNTHIUM_ALKALIDE: String = current.RESOURCE_CATALYZED_ZYNTHIUM_ALKALIDE
  def RESOURCE_CATALYZED_GHODIUM_ACID: String = current.RESOURCE_CATALYZED_GHODIUM_ACID
  def RESOURCE_CATALYZED_GHODIUM_ALKALIDE: String = current.RESOURCE_CATALYZED_GHODIUM_ALKALIDE

  def REACTIONS: js.Dictionary[js.Dictionary[String]] = current.REACTIONS

  def BOOSTS: js.Dictionary[js.Dictionary[js.Dictionary[Double]]] = current.BOOSTS

  def BODYPARTS_ALL: js.Array[String] = current.BODYPARTS_ALL
  def RESOURCES_ALL: js.Array[String] = current.RESOURCES_ALL
  def COLORS_ALL: js.Array[Int] = current.COLORS_ALL

  def Game: Task[Game] = Task.delay(current.Game)

  def Memory: Task[js.Dynamic] = Task.delay(current.Memory)

  def RawMemory: Task[RawMemory] = Task.delay(current.RawMemory)

  def PathFinder: Task[PathFinder] = Task.delay(current.PathFinder)

  def Console: Task[Console] = Task.delay(current.Console)

  def Room: Task[RoomTypeObject] = Task.delay(current.Room)

  def LoDash: Task[js.Dynamic] = Task.delay(current.LoDash)
}