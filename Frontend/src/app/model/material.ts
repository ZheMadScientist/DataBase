import {Tags} from "./tags";
import {Content} from "./content";

export interface Material {
  GUID: number,
  name: string,
  description: string,
  content: Content,
  tags: Tags
}
